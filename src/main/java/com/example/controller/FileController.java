package com.example.controller;

import com.example.utils.MinioUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jiangqiangqiang
 * @description:
 * @date 2023/3/10 11:17
 */
@Controller
public class FileController {
    private final MinioUtil minioUtil;

    public FileController(MinioUtil minioUtil) {
        this.minioUtil = minioUtil;
    }

    @PostMapping("/upload")
    public ResponseEntity upload(MultipartFile file) {
        String upload = minioUtil.upload(file);
        String preview = minioUtil.preview(upload);
        return ResponseEntity.ok(preview);
    }
}
