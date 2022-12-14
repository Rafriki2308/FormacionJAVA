package com.bosonit.ej13.uploaddownloadfile.file.infraestructure.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseFile {

    private String name;
    private String url;
    private String category;
    private long size;
}
