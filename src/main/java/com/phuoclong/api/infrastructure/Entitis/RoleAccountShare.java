package com.phuoclong.api.infrastructure.Entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name ="role_account_share")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAccountShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name = "account_id")
    @Type(type = "uuid-char")
    UUID accountId;

    @Column(nullable = false, name ="share_id")
    @Type(type = "uuid-char")
    UUID shareId;

    // owner,  editor, viewer,
    @Column(nullable = false,name = "role",columnDefinition = "varchar(50)")
    String role = "viewer";

}
