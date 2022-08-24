package com.example.demo.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ItemException;
import com.example.demo.models.Item;
import com.example.demo.request.UpdateEstadoItem;
import com.example.demo.services.ItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ItemsController {

	@Autowired
	private SimpMessagingTemplate webSocket;
	
    @Autowired
    private ItemService service;
    
  

    @GetMapping 
    public List<Item> listar() {
        return service.listar();
   
    }
    
    @GetMapping("/list")
    public List<Item> listar2() {
        return service.listar();
   
    }
    
     

    @GetMapping("/findItem/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Item> usuarioOptional = service.porId(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
 
    
    @PostMapping("/crearItems")
    public ResponseEntity<?> crear2(@Valid @RequestBody Item item, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }

          try {
			item = service.guardar(item);
		} catch (ItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCode() + " " + e.getMessage());
		}
    	webSocket.convertAndSend("/chat/historial", service.listar());
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
    
    @PostMapping("/updateEstadoItems")
    public ResponseEntity<?> UpdateEstadoItems(@Valid @RequestBody UpdateEstadoItem updateEstadoItem, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }

        Item item = service.updateEstadoItems(updateEstadoItem);
     
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
    
    //UpdateEstadoItem

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Item item, BindingResult result, @PathVariable Long id) {

        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Item> o = service.porId(id);
        if (o.isPresent()) {
            Item itemDb = o.get();


            itemDb.setNombre(item.getNombre());

            try {
				return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(itemDb));
			} catch (ItemException e) {
				// TODO Auto-generated catch block
	  			e.printStackTrace();
	  			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCode() + " " + e.getMessage());
			}
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Item> o = service.porId(id);
        if (o.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    
    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
    

    
}
