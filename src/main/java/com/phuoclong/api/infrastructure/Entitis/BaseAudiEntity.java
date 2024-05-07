package com.phuoclong.api.infrastructure.Entitis;

import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@MappedSuperclass
@Data
public abstract class BaseAudiEntity {
    @Column(nullable = false, name="created_date")
    protected OffsetDateTime createdDate = OffsetDateTime.now(ZoneOffset.UTC);

    @Column(name = "modified_date")
    protected OffsetDateTime modifiedDate;

    @Column(length = 36,nullable = false, name = "created_by")
    protected String createdBy;

    @Column(length = 36, name = "modified_by")
    protected String modifiedBy;

    @PreUpdate
    protected void onUpdate() {

        modifiedDate = OffsetDateTime.now(ZoneOffset.UTC);

        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            modifiedBy = authentication.getName();
        }
    }

    @PrePersist
    protected void onCreated(){
        createdDate = OffsetDateTime.now(ZoneOffset.UTC);

        if(createdBy == null || createdBy.isBlank()){
            var authentication = SecurityContextHolder.getContext().getAuthentication();

            if(authentication != null){
                createdBy = authentication.getName();
            }
        }

    }
}
