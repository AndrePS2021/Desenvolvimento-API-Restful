package org.serratec.backend.h2banco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Manutencao;
import org.serratec.backend.h2banco.service.ManutencaoService;
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
@RequestMapping("/manutencoes")
public class ManutencaoController {

	@Autowired
	private ManutencaoService manutencaoService;
	
	@GetMapping
	public ResponseEntity<List<Manutencao>> pesquisarTodos() {
		List<Manutencao> listaManutencaos = manutencaoService.pesquisarTodos();
		return ResponseEntity.ok(listaManutencaos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Manutencao> pesquisarUm(@PathVariable Long id) {
		Optional<Manutencao> Manutencao = manutencaoService.pesquisarUm(id);
		if (Manutencao.isPresent()) {
			return ResponseEntity.ok(Manutencao.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Manutencao> inserir(@Valid @RequestBody Manutencao manutencao, UriComponentsBuilder b) {
		manutencao = manutencaoService.inserir(manutencao);
		UriComponents uriComponents = b.path("/manutencoes/{id}").buildAndExpand(manutencao.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(manutencao);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Manutencao> atualizar(@Valid @RequestBody Manutencao manutencao, @PathVariable Long id) {
		if (!manutencaoService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		manutencao.setId(id);
		manutencao = manutencaoService.inserir(manutencao);
		return ResponseEntity.ok(manutencao);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!manutencaoService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		manutencaoService.remover(id);
		return ResponseEntity.noContent().build();
	}

}
