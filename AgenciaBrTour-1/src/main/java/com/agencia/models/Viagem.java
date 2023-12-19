package com.agencia.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_viagem;
    private String data_ida;
    private String data_volta;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;

	public Long getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(Long id_viagem) {
		this.id_viagem = id_viagem;
	}

	public String getData_ida() {
		return data_ida;
	}

	public void setData_ida(String data_ida) {
		this.data_ida = data_ida;
	}

	public String getData_volta() {
		return data_volta;
	}

	public void setData_volta(String data_volta) {
		this.data_volta = data_volta;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
    
    

} 
