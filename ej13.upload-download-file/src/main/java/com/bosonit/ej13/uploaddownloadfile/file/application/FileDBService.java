package com.bosonit.ej13.uploaddownloadfile.file.application;

import com.bosonit.ej13.uploaddownloadfile.file.domain.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileDBService {

    FileDB store(MultipartFile file, Path root) throws IOException;

    FileDB getFileById(String id);

    Stream<FileDB> getAllFiles();
}
