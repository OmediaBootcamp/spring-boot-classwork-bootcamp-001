package dev.omedia.controller;

import dev.omedia.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("upload")
public class FileUploadController {

    @PostMapping("1")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        final String originalFilename = file.getOriginalFilename();
        log.info("file {} uploaded. size = {}", originalFilename, file.getSize());
    }

    @PostMapping("2")
    public void uploadFile2(@RequestBody Item item) {

        byte[] decode = Base64.getDecoder().decode(item.getBase64File());
        int length = decode.length;
        try {
            Files.write(Path.of("a.pdf"), decode, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("file {} uploaded. size = {}", item.getName(), length);
    }
}
