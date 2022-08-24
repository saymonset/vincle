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

import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest 
public class ClienteServiceImplTest {


	 
	@Autowired
	@Qualifier("cliente")
	ClienteService service;

	
	@Test
	@Order(1)
	void findById() throws Exception {
		Optional<Cliente> obj = service.findById(1L);
		assertTrue(obj.isPresent());
		assertEquals("CocaCola", obj.orElseThrow().getNombre());
	}
	
	
	@Test
	@Order(2)
	void listar() {
		// TODO Auto-generated method stub
		List<Cliente> lst =  (List<Cliente>) service.listar();
		assertEquals(1,lst.size());
	}

	@Test
	@Order(3)
	void guardar() {
		// TODO Auto-generated method stub
		Cliente obj = new Cliente("Samsung");
		obj = service.guardar(obj);
		assertEquals("Samsung",obj.getNombre());
	}
	
	@Disabled
	@Test
	@Order(4)
	void eliminar() {
		Optional<Cliente> opt =service.findById(1l);
		if (opt.isPresent()) {
			service.eliminar(opt.get().getId());	
		}
		opt =service.findById(1l);
		assertEquals(false, opt.isPresent());
	}
}
