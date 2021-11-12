package org.serratec.backend.h2banco.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.h2banco.domain.Proprietario;

public interface ProprietarioService {

	List<Proprietario> pesquisarTodos();
	Optional<Proprietario> pesquisarUm(Long idProprietario);
	Proprietario inserir(Proprietario proprietario);
	boolean idExiste(Long id);
	void remover(Long id);
	List<Proprietario> inserirVarios(List<Proprietario> listaProprietario);
}
