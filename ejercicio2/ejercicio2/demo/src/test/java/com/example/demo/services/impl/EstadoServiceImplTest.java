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

import com.example.demo.models.Estado;
import com.example.demo.services.EstadoService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest 
public class EstadoServiceImplTest {

	

	@Autowired
	@Qualifier("estado")
	EstadoService service;

	@Test
	@Order(1)
	void findById() throws Exception {
		Optional<Estado> obj = service.findById(1L);
		assertTrue(obj.isPresent());
		assertEquals("WAITING", obj.orElseThrow().getNombre());
	}
	
	@Test
	@Order(2)
	void listar() {
		// TODO Auto-generated method stub
		List<Estado> lst =  (List<Estado>) service.listar();
		assertEquals(3,lst.size());
	}

	@Test
	@Order(3)
	void guardar() {
		// TODO Auto-generated method stub
		Estado obj = new Estado("Aproved");
		obj = service.guardar(obj);
		assertEquals("Aproved",obj.getNombre());
	}
	@Disabled
	@Test
	@Order(4)
	void eliminar() {
		Optional<Estado> opt =service.findById(1l);
		if (opt.isPresent()) {
			service.eliminar(opt.get().getId());	
		}
		opt =service.findById(1l);
		assertEquals(false, opt.isPresent());
	}
}
