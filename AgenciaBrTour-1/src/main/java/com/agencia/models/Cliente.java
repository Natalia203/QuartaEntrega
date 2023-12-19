package com.agencia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

	@Entity
	public class Cliente {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_cliente;	   
	    
	    private String nome;
	    private String cpf;
	    
	    private String telefone;
	    private String email;
	    
	    
	    
	    
	    
		public Long getId_cliente() {
			return id_cliente;
		}
		public void setId_cliente(Long id_cliente) {
			this.id_cliente = id_cliente;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

	    
}
