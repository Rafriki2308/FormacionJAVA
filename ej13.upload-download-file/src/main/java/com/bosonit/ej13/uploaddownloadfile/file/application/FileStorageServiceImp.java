package com.bosonit.ej13.uploaddownloadfile.file.application;

import com.bosonit.ej13.uploaddownloadfile.file.domain.FileDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class FileStorageServiceImp implements FileStorageService {

    @Value("${file.path}")
    private Path root;
    @Autowired
    private FileDBServiceImpl fileDBService;

    @Override
    public void init() {
        try {
            Files.createDirectory(root);

        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public FileDB save(MultipartFile file, String type) {
        String name = StringUtils.cleanPath(file.getContentType());
        String[] strings = name.split("/");
        String extension = strings[1];
        if (extension.equals(type)) {
            try {
                Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
                return fileDBService.store(file, root);

            } catch (Exception e) {
                throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
            }

        }
        throw new RuntimeException("Category file not matches");
    }


    @Override
    public Resource loadByName(String filename) {
        try {
            Path file = root.resolve(filename);

            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Resource loadById(String id) {
        try {
            String filename = fileDBService.
                    getFileById(id).
                    getName();
            Path file = root.resolve(filename);

            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }
}
