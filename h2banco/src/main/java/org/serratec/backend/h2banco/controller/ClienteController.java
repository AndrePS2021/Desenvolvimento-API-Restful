package org.serratec.backend.h2banco.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Cliente;
import org.serratec.backend.h2banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> Clientes = clienteService.pesquisarTodos();
		Clientes.forEach(p -> {
			p.add(linkTo(methodOn(ClienteController.class).pesquisar(p.getId())).withSelfRel());
		});
		return ResponseEntity.ok(Clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> pesquisar(@PathVariable Long id) {
		Optional<Cliente> Cliente = clienteService.pesquisarUm(id);
		if (Cliente.isPresent()) {
			Cliente.get().add(linkTo(methodOn(ClienteController.class).listar()).withSelfRel());
			return ResponseEntity.ok(Cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente, UriComponentsBuilder b) {
		cliente = clienteService.inserir(cliente);
		UriComponents uriComponents = b.path("/Clientes/{id}").buildAndExpand(cliente.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
		if (!clienteService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		cliente = clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!clienteService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteService.remover(id);
		return ResponseEntity.noContent().build();
	}
}
