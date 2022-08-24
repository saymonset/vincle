package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.models.Caracteristica;
import com.example.demo.repositories.CaracteristicaRepository;
import com.example.demo.services.CaracteristicaService;

@Service
@Qualifier("caracteristica")
public class CaracteristicaServiceImpl implements CaracteristicaService {

	 @Autowired
	 private CaracteristicaRepository repository;
	 
	 
		@Override
		public List<Caracteristica> listar() {
			// TODO Auto-generated method stub
			return (List<Caracteristica>) repository.findAll();
		}

		@Override
		public Optional<Caracteristica> findById(Long id) {
			// TODO Auto-generated method stub
			return repository.findById(id);
		}

		@Override
		public Caracteristica guardar(Caracteristica Caracteristica) {
			// TODO Auto-generated method stub
			return repository.save(Caracteristica);
		}

		@Override
		public void eliminar(Long id) {
			Optional<Caracteristica> opt =repository.findById(id);
			if (opt.isPresent()) {
				repository.delete(opt.get());	
			}
		}

		@Override
		public List<Caracteristica> listarPorIds(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return (List<Caracteristica>) repository.findAll();
		}
	 
 

}
