package com.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.models.Cliente;
import com.agencia.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente criarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente buscarClientePorId(Long id_cliente) {
		Optional<Cliente> opt = clienteRepository.findById(id_cliente);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public void apagarCliente(Long id_cliente){
		Cliente cliente = buscarClientePorId(id_cliente);
		clienteRepository.delete(cliente);
	}
	
	public Cliente editarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
