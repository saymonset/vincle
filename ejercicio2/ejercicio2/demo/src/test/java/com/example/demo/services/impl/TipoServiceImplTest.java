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

import com.example.demo.models.Tipo;
import com.example.demo.services.TipoService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest 
public class TipoServiceImplTest {


	@Autowired
	@Qualifier("tipo")
	TipoService service;

	@Test
	@Order(1)
	void findById() throws Exception {
		Optional<Tipo> obj = service.findById(2L);
		assertTrue(obj.isPresent());
		assertEquals("comida", obj.orElseThrow().getNombre());
	}
	
	@Test
	@Order(2)
	void listar() {
		// TODO Auto-generated method stub
		List<Tipo> lst =  (List<Tipo>) service.listar();
		assertEquals(4,lst.size());
	}

	@Test
	@Order(3)
	void guardar() {
		// TODO Auto-generated method stub
		Tipo obj = new Tipo("Granos");
		obj = service.guardar(obj);
		assertEquals("Granos",obj.getNombre());
	}
	
	@Disabled
	@Test
	@Order(4)
	void eliminar() {
		Optional<Tipo> opt =service.findById(1l);
		if (opt.isPresent()) {
			service.eliminar(opt.get().getId());	
		}
		opt =service.findById(1l);
		assertEquals(false, opt.isPresent());
	}
}
