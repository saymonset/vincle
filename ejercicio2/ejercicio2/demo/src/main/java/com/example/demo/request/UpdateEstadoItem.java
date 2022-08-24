package com.example.demo.request;

import java.io.Serializable;

public class UpdateEstadoItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long itemId;
	private Long estadoId;
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}

}
