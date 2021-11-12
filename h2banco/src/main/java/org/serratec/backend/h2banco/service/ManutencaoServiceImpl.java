package org.serratec.backend.h2banco.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.h2banco.domain.Manutencao;
import org.serratec.backend.h2banco.repository.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManutencaoServiceImpl implements ManutencaoService {

	@Autowired
	private ManutencaoRepository manutencaoRepository;
	
	@Override
	public List<Manutencao> pesquisarTodos() {
		return manutencaoRepository.findAll();
	}

	@Override
	public Optional<Manutencao> pesquisarUm(Long idManutencao) {
		return manutencaoRepository.findById(idManutencao);
	}
	
	@Override
	public Manutencao inserir(Manutencao manutencao) {
		return manutencaoRepository.save(manutencao);
	}

	@Override
	public boolean idExiste(Long id) {
		return manutencaoRepository.existsById(id);
	}

	@Override
	public void remover(Long id) {
		manutencaoRepository.deleteById(id);
	}
	
}
