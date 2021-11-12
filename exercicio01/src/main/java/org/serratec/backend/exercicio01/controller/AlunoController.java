package org.serratec.backend.exercicio01.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.exercicio01.domain.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	private static List<Aluno> lista = new ArrayList<Aluno>();
	
	@GetMapping
	public List<Aluno> listar() {
		
		lista.add(new Aluno("Davi Maçana", 1l, "21 987338454"));
		lista.add(new Aluno("Gustavo Ponte", 2l, "21 987334584"));
		lista.add(new Aluno("Leandro Fita", 3l, "21 957338454"));
		lista.add(new Aluno("Luciana Evangelista", 4l, "21 987385254"));
		
		return lista;
	}
	
	@GetMapping("{matricula}")
	public Aluno buscar(@PathVariable Long matricula) {
		for (Aluno aluno: lista) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno inserir(@RequestBody Aluno aluno) {
		lista.add(aluno);
		return aluno;
	}
	
	@DeleteMapping("{matricula}")
	public void delete(@PathVariable Long matricula) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getMatricula().equals(matricula)) {
				lista.remove(i);
			}
		}
	}
	
	@PutMapping("{matricula}")
	public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable Long matricula) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getMatricula().equals(matricula)) {
				Aluno a = new Aluno(aluno.getNome(), matricula,aluno.getTelefone());
				lista.set(i, a);
				return a;
	}
		}
		return null;
	}
	
}
