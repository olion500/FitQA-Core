package com.cocovo.fitqaspringjava.domain.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileUploader {

    List<String> uploadFiles(String destination, MultipartFile... multipartFiles) throws IOException;
}

