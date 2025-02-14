package com.phuoclong.api.infrastructure.controllers;


import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.phuoclong.api.features.share.services.AccountService;
import com.phuoclong.api.infrastructure.Entitis.AccountEntity;
import com.phuoclong.api.infrastructure.command.BaseIdentityCommand;
import com.phuoclong.api.infrastructure.configurations.services.UserDetailsModelService;
import com.phuoclong.api.infrastructure.response.ResponseMessage;
import com.phuoclong.api.infrastructure.response.ResponseMessageOf;
import com.phuoclong.api.infrastructure.services.AuthenticationManager;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;


@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@PreAuthorize("hasRole('public_site')")
@AllArgsConstructor
public class BaseController {

    private  Pipeline pipeline;

    private  AuthenticationManager authenticationManager;

    private  AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    protected UUID getAccountId(){
        var account =(UserDetailsModelService) authenticationManager.getAuthentication().getPrincipal();

        return account.getId();
    }

    protected AccountEntity getAccountInfo(){
        var accountId = getAccountId();

        return accountService.get(accountId);

    }


    protected <T> ResponseEntity<T> handle(Command<T> command) {
        try
        {
            if(command instanceof BaseIdentityCommand<?>)
            {
                var account = getAccountInfo();

                if (account == null) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
                }

                ((BaseIdentityCommand<T>) command).setAccountId(account.getId());
            }

            var result = command.execute(pipeline);

            return ResponseEntity.ok(result);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);

            return ResponseEntity.internalServerError().build();
        }
    }

    protected <T> ResponseEntity<?> handleWithResponseMessage(Command<ResponseMessageOf<T>> command) {
        try {

            if(command instanceof BaseIdentityCommand<?>)
            {
                var account = getAccountInfo();

                if (account == null) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
                }

                ((BaseIdentityCommand<ResponseMessageOf<T>>) command).setAccountId(account.getId());
            }

            var message= command.execute(pipeline);

            if(message.getSucceeded())
            {
                return ResponseEntity.status(message.getStatus()).body(message.getData());

            }

            return ResponseEntity
                    .status(message.getStatus())
                    .body(new ResponseMessageOf<T>(message.getMessage() , message.getFieldErrors()));

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);

            return ResponseEntity.internalServerError().build();
        }

    }

    protected <T> ResponseEntity<T> handleWithResponse(Command<ResponseEntity<T>> command) {
        try {

            if(command instanceof BaseIdentityCommand<?>)
            {
                var account = getAccountInfo();
                if (account == null) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
                }
                ((BaseIdentityCommand<ResponseEntity<T>>) command).setAccountId(account.getId());
            }

            return command.execute(pipeline);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);

            return ResponseEntity.internalServerError().build();
        }

    }

    private ResponseEntity<?> handleBadRequest(BindingResult bindingResult){
        var errors = bindingResult.getFieldErrors();

        var errorRequests = new HashMap<String, String>();

        errors.forEach(i -> {
            errorRequests.put(i.getField(), i.getDefaultMessage());
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseMessage("invalid data" , errorRequests));
    }
}
