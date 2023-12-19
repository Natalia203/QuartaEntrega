package com.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.agencia.models.Destino;
import com.agencia.service.DestinoService;

@Controller
public class DestinoController{
	
	@Autowired
	private DestinoService destinoService;
	
	@GetMapping("/lista/destino")
	public String listarDestinos(Model model) {
		List<Destino> destinos = destinoService.buscarTodosDestinos();
		model.addAttribute("listaDestinos",destinos);
		return "/lista-destinos";		
	}
	
	@GetMapping("/novo/destino")
	public String novoDestino(Model model) {
		Destino destino = new Destino();
		model.addAttribute("novoDestino", destino);
		return "/novo-destino";
	}
	
	@PostMapping("/salvar/destino")
	public String salvarDestino(@ModelAttribute("novoDestino")Destino destino,
		RedirectAttributes attributes) {
		destinoService.criarDestino(destino);
		attributes.addFlashAttribute("mensagem", "Destino salvo!");
		return "redirect:/novo/destino";
	}
	
	@GetMapping("/apagar/destino/{destino}")
	public String apagarDestino(@PathVariable("destino") long id_destino) {
		destinoService.apagarDestino(id_destino);
		return "redirect:/lista/destino";
	}
	
	@GetMapping("/editar/destino/{destino}")
	public String editarFormDestino(@PathVariable("destino") long id_destino, Model model) {
		Destino destino = destinoService.buscarDestinoPorId(id_destino);
		model.addAttribute("objetoDestino", destino);
		return "/editar-destino";	
	}
	
	@PostMapping("/editar/destino/{destino}")
	public String editarDestino(@PathVariable("destino") long id_destino,
								@ModelAttribute("objetoDestino")Destino destino) {
		destino.setId_destino(id_destino);
		destinoService.editarDestino(destino);
		return"redirect:/lista/destino";
	}
}
	
