package com.bosonit.ej13.uploaddownloadfile.file.application;

import com.bosonit.ej13.uploaddownloadfile.file.domain.FileDB;
import com.bosonit.ej13.uploaddownloadfile.file.infraestructure.repository.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class FileDBServiceImpl implements FileDBService{

    @Autowired
    private FileDBRepository fR;

    public FileDB store(MultipartFile file, Path root) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB fileDB = new FileDB(fileName, file.getContentType(),root.toString());

        return fR.save(fileDB);
    }
    public FileDB getFileById(String id){
        return fR.getReferenceById(id);
    }

    public Stream<FileDB> getAllFiles(){
        return fR.findAll().stream();
    }



}
