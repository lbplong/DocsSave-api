package com.phuoclong.api.infrastructure.Entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "share_link", indexes = {
        @Index(name = "IX_SHARELINK_NAME", columnList = "name")
})
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ShareLinkEntity extends BaseAudiEntity{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    UUID id;

    @Column(nullable = false, name = "name")
    String name;

    @Column(name="file_id")
    @Type(type = "uuid-char")
    UUID fileId;

    @Column(nullable = false, name ="deleted")
    Integer deleted = 0;
}
