package org.serratec.backend.h2banco.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.h2banco.domain.Veiculo;
import org.serratec.backend.h2banco.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public List<Veiculo> pesquisarTodos() {
		return veiculoRepository.findAll();
	}

	@Override
	public Optional<Veiculo> pesquisarUm(Long idVeiculo) {
		return veiculoRepository.findById(idVeiculo);
	}
	
	@Override
	public Veiculo inserir(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public boolean idExiste(Long id) {
		return veiculoRepository.existsById(id);
	}

	@Override
	public void remover(Long id) {
		veiculoRepository.deleteById(id);
	}
	
}
