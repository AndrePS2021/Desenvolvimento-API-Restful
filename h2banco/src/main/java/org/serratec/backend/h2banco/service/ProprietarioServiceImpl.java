package org.serratec.backend.h2banco.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.h2banco.domain.Proprietario;
import org.serratec.backend.h2banco.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioServiceImpl implements ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@Override
	public List<Proprietario> pesquisarTodos() {
		return proprietarioRepository.findAll();
	}

	@Override
	public Optional<Proprietario> pesquisarUm(Long idProprietario) {
		return proprietarioRepository.findById(idProprietario);
	}
	
	@Override
	public Proprietario inserir(Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}

	@Override
	public boolean idExiste(Long id) {
		return proprietarioRepository.existsById(id);
	}

	@Override
	public void remover(Long id) {
		proprietarioRepository.deleteById(id);
	}

	@Override
	public List<Proprietario> inserirVarios(List<Proprietario> listaProprietario) {
		return proprietarioRepository.saveAll(listaProprietario);
	}
	
}
