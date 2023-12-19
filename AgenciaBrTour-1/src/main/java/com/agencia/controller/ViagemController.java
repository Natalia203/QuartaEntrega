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

import com.agencia.models.Viagem;
import com.agencia.service.ViagemService;

@Controller
public class ViagemController {

	@Autowired
	private ViagemService viagemService;
	
	@GetMapping("/lista/viagem")
	public String listarViagens(Model model) {
		List<Viagem> viagens = viagemService.buscarTodasViagens();
		model.addAttribute("listaViagens",viagens);
		return "/lista-viagens";		
	}
	
	@GetMapping("/nova/viagem")
	public String novoViagem(Model model) {
		Viagem viagem = new Viagem();
		model.addAttribute("novaViagem", viagem);
		return "/nova-viagem";
	}
	
	@PostMapping("/salvar/viagem")
	public String salvarViagem(@ModelAttribute("novaViagem")Viagem viagem,
		RedirectAttributes attributes) {
		viagemService.criarViagem(viagem);
		attributes.addFlashAttribute("mensagem", "Viagem salva!");
		return "redirect:/nova/viagem";
	}
	
	@GetMapping("/apagar/viagem/{viagem}")
	public String apagarViagem(@PathVariable("viagem") long id_viagem) {
		viagemService.apagarViagem(id_viagem);
		return "redirect:/lista/viagem";
	}
	
	@GetMapping("/editar/viagem/{viagem}")
	public String editarFormViagem(@PathVariable("viagem") long id_viagem, Model model) {
		Viagem viagem = viagemService.buscarViagemPorId(id_viagem);
		model.addAttribute("objetoViagem", viagem);
		return "/editar-viagem";	
	}
	
	@PostMapping("/editar/viagem/{viagem}")
	public String editarViagem(@PathVariable("viagem") long id_viagem,
								@ModelAttribute("objetoViagem")Viagem viagem) {
		viagem.setId_viagem(id_viagem);
		viagemService.editarViagem(viagem);
		return"redirect:/lista/viagem";
	}
}
