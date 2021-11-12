package org.serratec.backend.h2banco.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.h2banco.domain.Veiculo;

public interface VeiculoService {

	List<Veiculo> pesquisarTodos();
	Optional<Veiculo> pesquisarUm(Long idVeiculo);
	Veiculo inserir(Veiculo veiculo);
	boolean idExiste(Long id);
	void remover(Long id);
}
