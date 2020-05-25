package com.ubt.sistemimonitorimitfermave.controller;

import com.ubt.sistemimonitorimitfermave.data.KonfigurimiDTO;
import com.ubt.sistemimonitorimitfermave.data.KonfigurimiUpdateDTO;
import com.ubt.sistemimonitorimitfermave.service.KonfigurimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
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

    @PutMapping("")
    public ResponseEntity update(@RequestBody @Valid KonfigurimiUpdateDTO konfigurimiUpdateDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }
        if(konfigurimiService.update(konfigurimiUpdateDTO) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }

        if(konfigurimiService.update(konfigurimiUpdateDTO) != null){
            return ResponseEntity.ok(true);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }
}
