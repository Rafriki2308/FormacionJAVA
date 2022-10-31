package com.bosonit.ej13.uploaddownloadfile.file.application;

import com.bosonit.ej13.uploaddownloadfile.file.domain.FileDB;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    public void init();

    public FileDB save(MultipartFile file, String type) throws Exception;

    public Resource loadByName(String filename);

    public Resource loadById(String id);

    public void deleteAll();
}
