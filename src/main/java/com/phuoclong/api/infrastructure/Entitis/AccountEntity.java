package com.phuoclong.api.infrastructure.Entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "account",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
},indexes = {
        @Index(name = "IX_ACCOUNT_EMAIL", columnList = "email", unique = true),
        @Index(name = "IX_ACCOUNT_FIRSTNAME", columnList = "first_name"),
        @Index(name = "IX_ACCOUNT_LASTNAME", columnList = "last_name")

})
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class AccountEntity extends BaseAudiEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    UUID id;

    @Column(length = 50,name="username", columnDefinition = "nvarchar(50)")
    String username;

    @Column(length = 50,name="first_name", columnDefinition = "nvarchar(50)")
    String firstName;

    @Column(length = 50,name="last_name", columnDefinition = "nvarchar(50)")
    String lastName;

    @Column(length = 50, name="account", columnDefinition = "nvarchar(50)")
    String account;

    @Column(length = 200, name="email", nullable = false,columnDefinition = "nvarchar(200)")
    String email;

    @Column(length = 200, name="password", nullable = false, columnDefinition = "nvarchar(200)")
    String password;

    @Column(name = "check_in_time")
    OffsetDateTime checkInTime;

    //    0: sign in, 1: active, -1: deleted, -2 block
    @Column(nullable = false, name="status")
    Integer status = 0;

    @Column(columnDefinition = "nvarchar(500)", name="token")
    String token;

}
