package com.bosonit.ej13.uploaddownloadfile.file.application;

import com.bosonit.ej13.uploaddownloadfile.file.domain.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileDBService {

    FileDB store(MultipartFile file) throws IOException;

    FileDB getFile(String id);

    Stream<FileDB> getAllFiles();
}
