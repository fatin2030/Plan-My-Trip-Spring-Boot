package com.fatin_noor.planmytrip.attachment;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttachmentService {

    @Value("${UPLOAD_DIR}")
    private String uploadDir;
    @Value("${FILE_ALLOWED_TYPES}")
    private String allowedTypes;

    @PostConstruct
    public void initUploadDirectory() {
        try {
            Path dirPath = Paths.get(uploadDir);
            log.info("Upload directory configured as: {}", dirPath.toAbsolutePath());

            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
                log.info("Created upload directory: {}", dirPath.toAbsolutePath());
            }

            if (!Files.isWritable(dirPath)) {
                throw new RuntimeException("Upload directory is not writable: " + dirPath.toAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize upload directory: " + uploadDir, e);
        }
    }

    public String uploadFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File cannot be null or empty");
        }

        validateFile(file);

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path dirPath = Paths.get(uploadDir);

        // Ensure directory exists
        if (!Files.exists(dirPath)) {
            try {
                Files.createDirectories(dirPath);
                log.info("Created missing upload directory: {}", dirPath.toAbsolutePath());
            } catch (IOException e) {
                log.error("Failed to create upload directory: {}", dirPath.toAbsolutePath(), e);
                throw new IOException("Failed to create upload directory", e);
            }
        }

        Path filePath = dirPath.resolve(fileName);
        log.info("Attempting to save file to: {}", filePath.toAbsolutePath());

        try {
            file.transferTo(filePath.toFile());
            log.info("Successfully uploaded file: {}", filePath.toAbsolutePath());
            return filePath.toString();
        } catch (IOException e) {
            log.error("Failed to save file to: {}", filePath.toAbsolutePath(), e);
            throw new IOException("Failed to save file: " + fileName, e);
        }
    }

    private void validateFile(MultipartFile file) {
        List<String> allowed = List.of(allowedTypes.split(","));
        String contentType = file.getContentType();

        if (contentType == null || !allowed.contains(contentType)) {
            throw new IllegalArgumentException("Invalid file type: " + contentType + ". Allowed types: " + allowedTypes);
        }
    }
}
