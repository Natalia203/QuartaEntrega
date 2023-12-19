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

import com.agencia.models.Cliente;
import com.agencia.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public String novoCadastro () {
		return "/novo-cadastro";
	}
	
	@GetMapping("/lista/cliente")
	public String listarClientes(Model model) {
		List<Cliente> clientes = clienteService.buscarTodosClientes();
		model.addAttribute("listaClientes",clientes);
		return "/lista-clientes";
	}
	
	@GetMapping("/novo/cliente")
	public String novoCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("novoCliente",cliente);
		return "/novo-cliente";
				
	}
	
	@PostMapping("/salvar")
	public String salvarCliente(@ModelAttribute("novoCliente")Cliente cliente,
			RedirectAttributes attributes) {		
		clienteService.criarCliente(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo!");
		return "redirect:/novo/cliente";
	}
	
	@GetMapping("/apagar/cliente/{cliente}")
	public String apagarCliente(@PathVariable("cliente") long id_cliente) {
		clienteService.apagarCliente(id_cliente);
		return "redirect:/lista/cliente";
	}
	
	@GetMapping("/editar/cliente/{cliente}")
	public String editarFormCliente(@PathVariable("cliente") long id_cliente, RedirectAttributes attributes, Model model) {
		Cliente cliente = clienteService.buscarClientePorId(id_cliente);
		model.addAttribute("objetoCliente",cliente);		
		return "/editar-cliente";
	}
	
	@PostMapping("/editar/cliente/{cliente}")
	public String editarCliente(@PathVariable("cliente") long id_cliente, 
								@ModelAttribute("objetoCliente") Cliente cliente) {
		cliente.setId_cliente(id_cliente);
		clienteService.editarCliente(cliente);
		return "redirect:/lista/cliente";
	}
	
}
	
	