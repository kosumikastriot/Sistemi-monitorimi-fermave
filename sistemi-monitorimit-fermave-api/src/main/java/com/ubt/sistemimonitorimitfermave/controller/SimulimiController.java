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

    @PostMapping("/temperatura")
    public ResponseEntity simuloTemeraturen(@RequestParam(value = "min", required = false) Double min, @RequestParam(value = "max", required = false) Double max){
        return ResponseEntity.ok().body(simulimiService.simuloTemeraturen(min, max));
    }

    @PostMapping("/lageshtijaajrit")
    public ResponseEntity simuloLagshtiaAjrit(@RequestParam(value = "min", required = false) Double min, @RequestParam(value = "max", required = false) Double max){
        return ResponseEntity.ok().body(simulimiService.simuloLageshtiaAjrit(min, max));
    }

    @PostMapping("/ndriqimi")
    public ResponseEntity simuloNdricimin(@RequestParam(value = "min", required = false) Double min, @RequestParam(value = "max", required = false) Double max){
        return ResponseEntity.ok().body(simulimiService.simuloNdricimin(min,max));
    }

}
