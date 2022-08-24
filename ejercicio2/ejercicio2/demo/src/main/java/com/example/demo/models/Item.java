package com.example.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "items")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@ManyToOne
	// @JoinColumn(name="id_tipo")
	private Tipo tipo;

//	@ManyToOne
	//private Caracteristica caracteristica;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "id_item")
	private List<Caracteristica> caracteristicas;
	
	/**
	 *   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
    private List<Factura> facturas;

	 * */
	
	@ManyToOne
	private Capacidad capacidad;
	
	@ManyToOne
	private Envase envase;
	
	@ManyToOne
	private Estado estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinedDate;
	
	

	@Column(name = "identifidor")
	private String identifidor;
	
	@ManyToOne
	private Cliente nomCliente;
	
	private String nombre;
	
	@PrePersist
    public void prePersist() {
		this.joinedDate = new Date();
    }
	


	
	public Item(Tipo tipo, Caracteristica caracteristica, Capacidad capacidad, Envase envase, Estado estado,
			Date joinedDate, String identifidor, Cliente nomCliente, String nombre) {
		this();
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.envase = envase;
		this.estado = estado;
		this.joinedDate = joinedDate;
		this.identifidor = identifidor;
		this.nomCliente = nomCliente;
		this.nombre = nombre;
	}
	
	public Item() {
		this.caracteristicas = new ArrayList<Caracteristica>();
	}
	  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	 
	public Capacidad getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Capacidad capacidad) {
		this.capacidad = capacidad;
	}

	public Envase getEnvase() {
		return envase;
	}

	public void setEnvase(Envase envase) {
		this.envase = envase;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getIdentifidor() {
		return identifidor;
	}

	public void setIdentifidor(String identifidor) {
		this.identifidor = identifidor;
	}

	public Cliente getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(Cliente nomCliente) {
		this.nomCliente = nomCliente;
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
		return "Item [tipo=" + tipo + ", caracteristica=" + caracteristicas + ", capacidad=" + capacidad + ", envase="
				+ envase + ", estado=" + estado + ", joinedDate=" + joinedDate + ", identifidor=" + identifidor
				+ ", nomCliente=" + nomCliente + ", nombre=" + nombre + "]";
	}




	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}




	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
  
	 
}
