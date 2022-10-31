package com.bosonit.ej13.uploaddownloadfile.file.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "files")
public class FileDB {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String category;

    private String root;

    private LocalDateTime uploadDate;

    public FileDB (String name,String category, String root){
        setName(name);
        setCategory(category);
        setRoot(root);
        setUploadDate(LocalDateTime.now());
    }

}
