package com.example.demo.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.exceptions.ItemException;
import com.example.demo.models.Capacidad;
import com.example.demo.models.Caracteristica;
import com.example.demo.models.Cliente;
import com.example.demo.models.Envase;
import com.example.demo.models.Estado;
import com.example.demo.models.Item;
import com.example.demo.models.Tipo;
import com.example.demo.services.CapacidadService;
import com.example.demo.services.CaracteristicaService;
import com.example.demo.services.ClienteService;
import com.example.demo.services.EnvaseService;
import com.example.demo.services.EstadoService;
import com.example.demo.services.ItemService;
import com.example.demo.services.TipoService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest 
public class ItemServiceImplTest {

	 Logger logger = LoggerFactory.getLogger(ItemServiceImplTest.class);
	 
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
	
	@Test
	@Order(3)
	void guardar() throws ItemException {
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
        

        Caracteristica caracteristica = new Caracteristica("Precisa nevera");
        obj.getCaracteristicas().add(caracteristica);
        caracteristica = new Caracteristica("No precisa nevera");
        obj.getCaracteristicas().add(caracteristica);
        
        obj.setCapacidad(cap.get());
        obj.setEnvase(env.get());
        obj.setTipo(objTipo.get());
        obj.setEstado(edo.get());
        obj.setNomCliente(cli.get());
        obj.setIdentifidor("SSSSHHH16161661jjjjJJ");
		
		obj = service.guardar(obj);
		logger.info(obj.toString());
		assertEquals("bebida",obj.getTipo().getNombre());
		//assertEquals(2,obj.getCaracteristicas().size());
		assertEquals("100 gr",obj.getCapacidad().getNombre());
		assertEquals("Botella",obj.getEnvase().getNombre());
		assertEquals("WAITING",obj.getEstado().getNombre());
		System.out.println("------------1-------------");
		System.out.println(obj.toString());
		System.out.println("-----------2--------------");
		 
	}
}
