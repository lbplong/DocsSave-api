package com.phuoclong.api.infrastructure.Entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "file", indexes = {
        @Index(name="IX_FILE_NAME",columnList = "name")
})
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class FileEntity extends BaseAudiEntity{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    UUID id;

    @Column(nullable = false,name="name", columnDefinition = "nvarchar(255)")
    String name;

    @Column(nullable = false,name = "display_name", columnDefinition = "nvarchar(255)")
    String displayName;

    @Column(nullable = false, name = "size")
    Long size;

    @Column(name = "account_id", length = 36)
    @Type(type = "uuid-char")
    UUID accountId;

    @Column(name = "directory_id", length = 36)
    @Type(type = "uuid-char")
    UUID directoryId;

    @Column(nullable = false, name = "type")
    String type;

    @Column(nullable = false, name ="deleted")
    Integer deleted = 0;
}
