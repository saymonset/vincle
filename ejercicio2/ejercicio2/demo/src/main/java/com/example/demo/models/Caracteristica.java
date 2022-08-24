package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "caracteristicas")
public class Caracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	
	public Caracteristica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Caracteristica(@NotBlank(message = "El nombre es obligatorio") String nombre) {
		super();
		this.nombre = nombre;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Caracteristica [nombre=" + nombre + "]";
	}

}
