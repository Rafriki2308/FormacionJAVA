package com.bosonit.ej13.uploaddownloadfile.file.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
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

    @Lob
    private byte[] data;

    public FileDB(String name, String category, byte[] data) {
        this.name = name;
        this.category = category;
        this.data = data;
    }

}
