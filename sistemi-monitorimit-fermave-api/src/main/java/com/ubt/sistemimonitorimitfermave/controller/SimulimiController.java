package com.ubt.sistemimonitorimitfermave.controller;

import com.ubt.sistemimonitorimitfermave.service.SimulimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/simulimi")
public class SimulimiController {

    @Autowired
    SimulimiService simulimiService;

    @PostMapping("")
    public ResponseEntity simuloTemeraturen(@RequestParam(value = "started", required = true) Boolean started, @RequestParam(value = "min", required = false) Double min, @RequestParam(value = "max", required = false) Double max){
        return ResponseEntity.ok().body(simulimiService.simuloTemeraturen(started, min, max));
    }

    @PostMapping("/LageshtijaAjrit")
    public ResponseEntity simuloLagshtiaAjrit(@RequestParam(value = "vlera", required = true) Double vlera){
        return ResponseEntity.ok().body(simulimiService.simuloLageshtiaAjrit(vlera));
    }

}
