package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.ItemException;
import com.example.demo.models.Capacidad;
import com.example.demo.models.Caracteristica;
import com.example.demo.models.Cliente;
import com.example.demo.models.Envase;
import com.example.demo.models.Estado;
import com.example.demo.models.Item;
import com.example.demo.models.Tipo;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.request.UpdateEstadoItem;
import com.example.demo.services.CapacidadService;
import com.example.demo.services.CaracteristicaService;
import com.example.demo.services.ClienteService;
import com.example.demo.services.EnvaseService;
import com.example.demo.services.EstadoService;
import com.example.demo.services.ItemService;
import com.example.demo.services.TipoService;

@Service
@Qualifier("item")
public class ItemServiceImpl implements ItemService {

	private List<Caracteristica> caracts = null;
	private List<Caracteristica> caractsInBd = null;
	@Autowired
	private ItemRepository repository;

	@Autowired
	@Qualifier("caracteristica")
	CaracteristicaService caracteristicaService;

	@Autowired
	@Qualifier("tipo")
	TipoService tipoService;

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

	@Override
	@Transactional(readOnly = true)
	public List<Item> listar() {
		return (List<Item>) repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Item> porId(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Item updateEstadoItems(UpdateEstadoItem updateEstadoItem) {

		Optional<Estado> edo = estadoService.findById(updateEstadoItem.getEstadoId());

		Optional<Item> item = this.porId(updateEstadoItem.getItemId());

		if (item.isPresent() && edo.isPresent()) {
			item.get().setEstado(edo.get());
			return repository.save(item.get());
		} else {
			return null;
		}

	}

	@Override
	@Transactional
	public Item guardar(Item item) throws ItemException {

		Optional<Cliente> cli = clienteService.findById(item.getNomCliente()!=null?item.getNomCliente().getId():0);
		Optional<Estado> edo = estadoService.findById(item.getEstado()!=null?item.getEstado().getId():0);
		Optional<Envase> env = envaseService.findById(item.getEnvase()!=null?item.getEnvase().getId():0);
		Optional<Capacidad> cap = capacidadService.findById(item.getCapacidad()!=null?item.getCapacidad().getId():0);
		Optional<Tipo> tipo = tipoService.findById(item.getTipo()!=null?item.getTipo().getId():0);
		if (!cli.isPresent()) {
			throw new ItemException("Cliente", "Fallo al guardar item");
		}

		if (!edo.isPresent()) {
			throw new ItemException("Estado", "Fallo al guardar item");
		}

		if (!env.isPresent()) {
			throw new ItemException("Envase", "Fallo al guardar item");
		}

		if (!cap.isPresent()) {
			throw new ItemException("Capacidad", "Fallo al guardar item");
		}

		
		if (!tipo.isPresent()) {
			throw new ItemException("Tipo", "Fallo al guardar item");
		}

		Item obj = new Item();

		obj.setCapacidad(cap.get());
		obj.setEnvase(env.get());
		obj.setTipo(tipo.get());
		obj.setEstado(edo.get());
		obj.setNomCliente(cli.get());
		obj.setIdentifidor(item.getIdentifidor());
		obj.setNombre(item.getNombre());

		obj.setCaracteristicas(item.getCaracteristicas());

		return repository.save(obj);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		repository.deleteById(id);
		// client.eliminarCursoUsuarioPorId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Item> listarPorIds(Iterable<Long> ids) {
		return (List<Item>) repository.findAllById(ids);
	}

}
