package com.phuoclong.api.infrastructure.Entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name ="visitor")
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class VisitorEntity extends BaseAudiEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    UUID id;

    @Column(nullable = false, name = "share_id")
    @Type(type = "uuid-char")
    UUID shareId;

    @Column(name = "email")
    String email;

    @Column(name = "name")
    String name;

    @Column(nullable = false, name = "duration")
    long duration = 0;

}
