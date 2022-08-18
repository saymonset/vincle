package com.prueba1.controllers;

import com.prueba1.servicios.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class NumeroController {
    @Autowired
    private NumeroService service;

    @GetMapping("/")
    public ResponseEntity<?> resultado(){


        Optional<String> resultadoOptional = service.resultado();
        if (resultadoOptional.isPresent()) {
            return ResponseEntity.ok(resultadoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
