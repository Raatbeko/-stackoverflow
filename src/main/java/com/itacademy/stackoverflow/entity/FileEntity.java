package com.itacademy.stackoverflow.entity;

import com.itacademy.stackoverflow.enums.FileType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileEntity extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "extension")
    private String extension;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private FileType fileType;
}
