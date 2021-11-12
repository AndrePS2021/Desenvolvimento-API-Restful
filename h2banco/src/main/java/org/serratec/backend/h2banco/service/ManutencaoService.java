package org.serratec.backend.h2banco.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.h2banco.domain.Manutencao;

public interface ManutencaoService {

	List<Manutencao> pesquisarTodos();
	Optional<Manutencao> pesquisarUm(Long idManutencao);
	Manutencao inserir(Manutencao manutencao);
	boolean idExiste(Long id);
	void remover(Long id);
}