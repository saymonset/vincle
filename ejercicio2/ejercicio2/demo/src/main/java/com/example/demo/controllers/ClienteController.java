package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Capacidad;
import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ClienteController {

	@Autowired
	@Qualifier("cliente")
	ClienteService service;

	 @GetMapping("/list")
	    public List<Cliente> listar2() {
	        return service.listar();
	   
	    }
	
	@PostMapping("/crearCliente")
    public ResponseEntity<?> crear2(@Valid @RequestBody Cliente obj, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }

        obj = service.guardar(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }
	
	  private ResponseEntity<Map<String, String>> validar(BindingResult result) {
	        Map<String, String> errores = new HashMap<>();
	        result.getFieldErrors().forEach(err -> {
	            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
	        });
	        return ResponseEntity.badRequest().body(errores);
	    }
}
