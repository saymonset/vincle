package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.models.Item;
import com.example.demo.repositories.ItemRepository;

@DataJpaTest
class DemoApplicationTests {
	
	
	 @Autowired
	 ItemRepository repository;
	
 
	 
	
	@Test
	void contextLoads() throws Exception {
		 Optional<Item> cuenta = repository.findById(1L);
	        assertTrue(cuenta.isPresent());
	        assertEquals("capacidad", cuenta.orElseThrow().getCapacidad());
				
	}

}
