package com.example.supercassa.controller;

import com.example.supercassa.SkExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modify")
public class SkExampleController {

    @Autowired
    private SkExampleService service;

    @PostMapping
    public ResponseEntity<?> modify(@RequestBody ModifyRequest request) {
        try {
            int current = service.modifyObject(request.id(), request.add());
            return ResponseEntity.ok(new ModifyResponse(current));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }
}
