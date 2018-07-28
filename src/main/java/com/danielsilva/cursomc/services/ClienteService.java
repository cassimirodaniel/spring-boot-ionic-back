package com.danielsilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsilva.cursomc.domain.Cliente;
import com.danielsilva.cursomc.repositories.ClienteRepository;
import com.danielsilva.cursomc.services.exception.ObjectNotFoundExecption;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExecption(
		"Objeto não encontrado! Id:" + id + ", Tipo: "
		 + Cliente.class.getName()));
	}

}
