package org.serratec.backend.h2banco.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.h2banco.domain.Cliente;
import org.serratec.backend.h2banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> pesquisarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> pesquisarUm(Long idCliente) {
		return clienteRepository.findById(idCliente);
	}
	
	@Override
	public Cliente inserir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public boolean idExiste(Long id) {
		return clienteRepository.existsById(id);
	}

	@Override
	public void remover(Long id) {
		clienteRepository.deleteById(id);
	}
	
}
