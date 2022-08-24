package com.sdl.template.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class AppController {
    

    @GetMapping("howold")
    public ResponseEntity<?> calculateAge(String dob) {
        return new ResponseEntity<>("User Age", HttpStatus.OK);
    }

}
