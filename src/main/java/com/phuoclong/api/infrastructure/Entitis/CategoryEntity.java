package com.phuoclong.api.infrastructure.Entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "category")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name = "account_id")
    @Type(type = "uuid-char")
    UUID accountId;

    @Column(nullable = false, name="file_id")
    @Type(type = "uuid-char")
    UUID fileId;

    @Column(nullable = false,name = "category_name", columnDefinition = "nvarchar(50)")
    String categoryName;

}
