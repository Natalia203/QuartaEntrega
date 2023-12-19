package com.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.models.Viagem;
import com.agencia.repository.ViagemRepository;

@Service
public class ViagemService {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	public Viagem criarViagem(Viagem viagem) {
		return viagemRepository.save(viagem);
	}

	public List<Viagem> buscarTodasViagens() {
		return viagemRepository.findAll();
	}
	
	public Viagem buscarViagemPorId(Long id_viagem) {
		Optional<Viagem> opt = viagemRepository.findById(id_viagem);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public void apagarViagem(Long id_viagem){
		Viagem viagem = buscarViagemPorId(id_viagem);
		viagemRepository.delete(viagem);
	}
	
	public Viagem editarViagem(Viagem viagem) {
		return viagemRepository.save(viagem);
	}
}
