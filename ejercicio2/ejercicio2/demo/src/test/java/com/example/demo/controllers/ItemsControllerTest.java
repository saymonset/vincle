package com.example.demo.controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.demo.exceptions.ItemException;
import com.example.demo.models.Capacidad;
import com.example.demo.models.Caracteristica;
import com.example.demo.models.Cliente;
import com.example.demo.models.Envase;
import com.example.demo.models.Estado;
import com.example.demo.models.Item;
import com.example.demo.models.Tipo;
import com.example.demo.request.UpdateEstadoItem;
import com.example.demo.services.CapacidadService;
import com.example.demo.services.CaracteristicaService;
import com.example.demo.services.ClienteService;
import com.example.demo.services.EnvaseService;
import com.example.demo.services.EstadoService;
import com.example.demo.services.ItemService;
import com.example.demo.services.TipoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemsControllerTest {

	 @Autowired
	    private TestRestTemplate client;

	    private ObjectMapper objectMapper;
	    
	    @Autowired
		@Qualifier("caracteristica")
		CaracteristicaService caracteristicaService;
		
		@Autowired
		@Qualifier("tipo")
		TipoService tipoService;
		
		@Autowired
		@Qualifier("item")
		ItemService service;
		
		@Autowired
		@Qualifier("capacidad")
		CapacidadService capacidadService;
		
		@Autowired
		@Qualifier("envase")
		EnvaseService envaseService;
		
		@Autowired
		@Qualifier("estado")
		EstadoService estadoService;

		@Autowired
		@Qualifier("cliente")
		ClienteService clienteService;
		

	    @LocalServerPort
	    private int puerto;

	    @BeforeEach
	    void setUp() {
	        objectMapper = new ObjectMapper();
	    }

	    
	    @Test
	    @Order(1)
	    void testCrearItems() throws JsonProcessingException {
		  
	        Optional<Cliente> cli = clienteService.findById(1L);
	 		assertTrue(cli.isPresent());
	 		
	 		Optional<Estado> edo = estadoService.findById(1L);
	 		assertTrue(edo.isPresent());
	 		
	 		Optional<Envase> env = envaseService.findById(1L);
	 		assertTrue(env.isPresent());
	 		
	 		Optional<Capacidad> cap = capacidadService.findById(1L);
	 		assertTrue(cap.isPresent());
	 		
	 		Optional<Tipo> objTipo = tipoService.findById(1L);
	 		assertTrue(objTipo.isPresent());
	 		
	 		 Item obj =	new Item();
	         

	 		 Caracteristica caracteristica = new Caracteristica("Precisa No nevera");
	 	 
     		 obj.getCaracteristicas().add(caracteristica);
	         obj.setCapacidad(cap.get());
	         obj.setEnvase(env.get());
	         obj.setTipo(objTipo.get());
	         obj.setEstado(edo.get());
	         obj.setNomCliente(cli.get());
	         obj.setIdentifidor("SSSSHHH16161661jjjjJJ");

	        ResponseEntity<String> response = client.
	                postForEntity(crearUri("/items/crearItems"), obj, String.class);
	        System.out.println(puerto);
	        String json = response.getBody();
	        System.out.println(json);
	        assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	        assertNotNull(json);
	        assertEquals("true", "true");
	    }
	    
	   
	    @Test
	    @Order(2)
	    void testUpdateEstadoItems() throws JsonProcessingException {
	 		
	    	
	    	Optional<Estado> edo = estadoService.findById(2L);
	 		assertTrue(edo.isPresent());
	    	
	 		Optional<Item> item = service.porId(9l);
	 		assertTrue(item.isPresent());
	 		assertEquals(item.get().getEstado().getNombre(),"WAITING");
	 		
	 		
	 		
	 	 
	 		UpdateEstadoItem updateEstadoItem = new UpdateEstadoItem();
	 		updateEstadoItem.setEstadoId(edo.get().getId());
	 		updateEstadoItem.setItemId(item.get().getId());
	 		Item  itemUpdate = service.updateEstadoItems(updateEstadoItem);
	 		
	 		assertEquals(itemUpdate.getEstado().getNombre(),"CREATED"); 
	 		
		 
	    }
	    
	    @Test
	    @Order(3)
	    void testUpdateCarcateristicasItems() throws JsonProcessingException, ItemException {
	 		
	 		Optional<Item> item = service.porId(9l);
	 		assertTrue(item.isPresent());
	 		 
	 		 item.get().setCaracteristicas(new ArrayList<Caracteristica>());
	 		 Caracteristica caracteristica = new Caracteristica("Precisa nevera");
	 		 item.get().getCaracteristicas().add(caracteristica);
      
	 		caracteristica = new Caracteristica("Precisa 120V");
	 		item.get().getCaracteristicas().add(caracteristica);
	 		
	 		caracteristica = new Caracteristica("Precisa ambiente seco");
	 		item.get().getCaracteristicas().add(caracteristica);
	 		
	 		Item  itemUpdate = service.guardar(item.get());
	 		
	 		assertEquals(itemUpdate.getCaracteristicas().size(),3); 
	 		
		 
	    }
	    
	    private String crearUri(String uri) {
	        return "http://localhost:" + puerto + uri;
	    }
	
}
