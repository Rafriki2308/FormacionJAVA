package com.bosonit.ej13.uploaddownloadfile.file.infraestructure.repository;

import com.bosonit.ej13.uploaddownloadfile.file.domain.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository <FileDB, String> {
}
