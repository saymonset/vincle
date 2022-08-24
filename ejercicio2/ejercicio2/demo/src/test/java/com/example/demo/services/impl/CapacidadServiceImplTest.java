package com.example.demo.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Capacidad;
import com.example.demo.repositories.CapacidadRepository;
import com.example.demo.services.CapacidadService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@DataJpaTest
@SpringBootTest 
public class CapacidadServiceImplTest {

	@Autowired
	CapacidadRepository repository;
	
	@Autowired
	@Qualifier("capacidad")
	CapacidadService service;

	@Test
	@Order(1)
	void findById() throws Exception {
		Optional<Capacidad> obj = service.findById(1L);
		assertTrue(obj.isPresent());
		assertEquals("100 gr", obj.orElseThrow().getNombre());
	}
	
	@Test
	@Order(2)
	void listar() {
		// TODO Auto-generated method stub
		List<Capacidad> lst =  (List<Capacidad>) service.listar();
		assertEquals(1,lst.size());
	}

	@Test
	@Order(3)
	void guardar() {
		// TODO Auto-generated method stub
		Capacidad obj = new Capacidad("1000 tonladas");
		obj = service.guardar(obj);
		assertEquals("1000 tonladas",obj.getNombre());
	}
	
	@Disabled
	@Test
	@Order(4)
	void eliminar() {
		Optional<Capacidad> opt =service.findById(1l);
		if (opt.isPresent()) {
			service.eliminar(opt.get().getId());	
		}
		opt =service.findById(1l);
		assertEquals(false, opt.isPresent());
	}
	
	
	
}
