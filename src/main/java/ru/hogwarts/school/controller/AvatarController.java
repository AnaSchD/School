package ru.hogwarts.school.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.service.AvatarService;

import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping ("/avatar")
public class AvatarController {

    private AvatarService avatarService;

    @PostMapping (value = "/{studentId}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity <String> uploadAvatar (@PathVariable Long studentId, @RequestParam MultipartFile avatar) throws IOException {
//        if (avatar.getSize() > 1024 * 300) {
//            return ResponseEntity.badRequest().body("File is too big");
//        }
        avatarService.uploadAvatar(studentId, avatar);
        return ResponseEntity.ok().build();
    }

}
