package com.ubt.sistemimonitorimitfermave.controller;

import com.ubt.sistemimonitorimitfermave.data.KonfigurimiDTO;
import com.ubt.sistemimonitorimitfermave.service.KonfigurimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/konfigurimi")
public class KonfigurimiController {

    @Autowired
    private KonfigurimiService konfigurimiService;

    @GetMapping("")
    public ResponseEntity getAll(){
        List<KonfigurimiDTO> result = konfigurimiService.getAll();
        if (result == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        }
        return ResponseEntity.ok(result);
    }
}
