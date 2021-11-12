package org.serratec.backend.h2banco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Proprietario;

import org.serratec.backend.h2banco.service.ProprietarioService;
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
@RequestMapping("/proprietarios")
public class ProprietarioController {
	
	@Autowired
	private ProprietarioService proprietarioService;
	
	@PostMapping
	public ResponseEntity<Proprietario> inserir(@Valid @RequestBody Proprietario proprietario, UriComponentsBuilder b) {
		UriComponents uriComponents = b.path("/proprietarios/{id}").buildAndExpand(proprietario.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(proprietarioService.inserir(proprietario));
	}
	
	@PostMapping("/lista")
	public ResponseEntity<List<Proprietario>> inserirVarios(@Valid @RequestBody List<Proprietario> listaProprietario, UriComponentsBuilder b) {
		UriComponents uriComponents = b.path("/proprietarios").buildAndExpand();
		return ResponseEntity.created(uriComponents.toUri()).body(proprietarioService.inserirVarios(listaProprietario));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Proprietario>>PesquisarTodos() {
		List<Proprietario> listaProprietarios = proprietarioService.pesquisarTodos();
		return ResponseEntity.ok(listaProprietarios);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proprietario> pesquisarUm(@PathVariable Long id){
		Optional<Proprietario> Proprietario = proprietarioService.pesquisarUm(id);
		if (Proprietario.isPresent()) {
			return ResponseEntity.ok(Proprietario.get());
		}
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<Proprietario> atualizar(@Valid @RequestBody Proprietario proprietario, @PathVariable Long id){
		if (!proprietarioService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		proprietario.setId(id);
		proprietario = proprietarioService.inserir(proprietario);
		return ResponseEntity.ok(proprietario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		if (!proprietarioService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		proprietarioService.remover(id);;
		return ResponseEntity.noContent().build();
	}	

}
