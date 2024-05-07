package com.phuoclong.api.infrastructure.Entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="directory", indexes = {
        @Index(name="IX_DIRECTORY_NAME" ,columnList = "name")
})
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class DirectoryEntity extends BaseAudiEntity{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    UUID id;

    @Column(length = 50,nullable = false,name = "name", columnDefinition = "nvarchar(50)")
    String name;

    // 1: document 2: musics 3:photo 4: movies
    @Column(nullable = false,name = "level", columnDefinition = "integer")
    Integer level = 0;

    @Column(nullable = false, name = "parent_id")
    @Type(type = "uuid-char")
    UUID parentId;

    @Column(nullable = false, name ="account_id")
    @Type(type = "uuid-char")
    UUID accountId;

    @Column(name="deleted")
    Integer deleted = 0;
}
