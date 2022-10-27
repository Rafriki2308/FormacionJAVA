package com.bosonit.ej13.uploaddownloadfile.file.application;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService {

    public void init();

    public void save(MultipartFile file);

    public Resource loadByName(String filename);

}
