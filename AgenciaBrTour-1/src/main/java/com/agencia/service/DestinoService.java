package com.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia.models.Destino;
import com.agencia.repository.DestinoRepository;

@Service
public class DestinoService {
	@Autowired
	private DestinoRepository destinoRepository;
	
	public Destino criarDestino(Destino destino) {
		return destinoRepository.save(destino);
	}
	
	public List<Destino> buscarTodosDestinos() {
		return destinoRepository.findAll();
	}
	
	public Destino buscarDestinoPorId(Long id_destino) {
		Optional<Destino> opt = destinoRepository.findById(id_destino);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public void apagarDestino(Long id_destino){
		Destino destino = buscarDestinoPorId(id_destino);
		destinoRepository.delete(destino);
	}
	
	public Destino editarDestino(Destino destino) {
		return destinoRepository.save(destino);
	}
}
