package com.bosonit.ej13.uploaddownloadfile.file.infraestructure.controller;

import com.bosonit.ej13.uploaddownloadfile.file.application.FileDBServiceImpl;
import com.bosonit.ej13.uploaddownloadfile.file.application.FileStorageServiceImp;
import com.bosonit.ej13.uploaddownloadfile.file.infraestructure.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@CrossOrigin("http://localhost:8080")
public class FileController {

    @Autowired
    private FileDBServiceImpl fileService;
    @Autowired
    private FileStorageServiceImp storageService;

    @PostMapping("/upload/{type}")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String type) {
        String message = "";
        try {
            return ResponseEntity.status(HttpStatus.OK).body(storageService.save(file, type));

        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/downloadByName/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFileByName(@PathVariable String filename) {
        Resource file = storageService.loadByName(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                file.getFilename() + "\"").body(file);
    }

    @GetMapping("/downloadById/{id}")
    @ResponseBody
    public ResponseEntity<Resource> getFileById(@PathVariable String id) {
        Resource file = storageService.loadById(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                file.getFilename() + "\"").body(file);
    }
}
