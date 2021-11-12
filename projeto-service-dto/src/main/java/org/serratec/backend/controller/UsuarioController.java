package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.dto.UsuarioRequestDTO;
import org.serratec.backend.dto.UsuarioResponseDTO;
import org.serratec.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioResponseDTO>> pesquisarTodos() {
		return ResponseEntity.ok(usuarioService.pesquisarTodos());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioResponseDTO> inserir(@RequestBody UsuarioRequestDTO user, UriComponentsBuilder b) {
		UsuarioResponseDTO usuarioDTO = usuarioService.inserir(user);
		UriComponents uriComponents = b.path("/usuarios/{id}").buildAndExpand(usuarioDTO.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(usuarioDTO);
	}
}
