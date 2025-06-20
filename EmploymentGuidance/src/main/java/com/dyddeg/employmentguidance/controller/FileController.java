package com.dyddeg.employmentguidance.controller;

import com.dyddeg.employmentguidance.pojo.entity.Rfile;
import com.dyddeg.employmentguidance.result.Result;
import com.dyddeg.employmentguidance.service.RfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


    @RestController
    public class FileController {

        @Autowired
        private RfileService rfileService;

        @Value("${file.upload-dir}")
        private String uploadDirPath;

        // 获取当前类所在项目的运行目录（通常是项目根目录或 target/classes）
        private Path uploadDir= null;
        @PostConstruct
        public void init() {
            uploadDir = Paths.get(uploadDirPath);
        }
        @PostMapping("/upload")
        public Result uploadFile(
                @RequestParam("file") MultipartFile file,
                @RequestParam("rfile") String rfile) throws IOException {

            ObjectMapper objectMapper = new ObjectMapper();
            Rfile rfile1 = objectMapper.readValue(rfile, Rfile.class);

            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null || originalFilename.isEmpty()) {
                return Result.error("文件名不能为空");
            }

            // 保存文件到服务器
            Path filePath = uploadDir.resolve(originalFilename);
            file.transferTo(filePath.toFile());

            rfile1.setFname(originalFilename);
            // 假设你有一个 service 或 repository 来保存 rfile 到数据库
            rfileService.addFile(rfile1);

            return Result.success(rfile1); // 返回保存后的实体对象
        }


        @PostMapping("/download/{fileName}")
        public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
            // 构建文件路径
            Path filePath = uploadDir.resolve(fileName);
            Resource resource = new FileSystemResource(filePath);

            // 判断文件是否存在
            if (!resource.exists()) {
                return ResponseEntity.status(404).body(null);
            }

            // 设置响应头，触发浏览器下载行为
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + java.net.URLEncoder.encode(fileName, "UTF-8") + "\"")
                    .body(resource);
        }

        @PostMapping("/findFile")
        public Result findFile(@RequestBody Rfile rfile) {
            System.out.println(rfile.getRid());
            return Result.success(rfileService.findFile(rfile.getRid()));
        }
    }


