package com.serviceassurance.payall.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorieAuto")
// @CrossOrigin(origins = "*")
public class checkApiKey {

private class data {
    public String name;
}
    @GetMapping
    public  ResponseEntity<?> createAutomotiveCategory()  {
        return new ResponseEntity<>("jjjj",
        HttpStatus.CREATED);
    }

}
