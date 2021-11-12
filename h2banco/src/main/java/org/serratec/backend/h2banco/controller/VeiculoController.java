package org.serratec.backend.h2banco.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.h2banco.domain.Veiculo;
import org.serratec.backend.h2banco.service.VeiculoService;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os veículos cadastrados", notes = "Veículos dos clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os veículos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	public ResponseEntity<List<Veiculo>> pesquisarTodos() {
		List<Veiculo> listaVeiculos = veiculoService.pesquisarTodos();
		return ResponseEntity.ok(listaVeiculos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> pesquisarUm(@PathVariable Long id) {
		Optional<Veiculo> Veiculo = veiculoService.pesquisarUm(id);
		if (Veiculo.isPresent()) {
			return ResponseEntity.ok(Veiculo.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> inserir(@Valid @RequestBody Veiculo veiculo, UriComponentsBuilder b) {
		UriComponents uriComponents = b.path("/Veiculos/{id}").buildAndExpand(veiculo.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(veiculoService.inserir(veiculo));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizar(@Valid @RequestBody Veiculo veiculo, @PathVariable Long id) {
		if (!veiculoService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		veiculo.setId(id);
		veiculo = veiculoService.inserir(veiculo);
		return ResponseEntity.ok(veiculo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!veiculoService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		veiculoService.remover(id);
		return ResponseEntity.noContent().build();
	}

}
