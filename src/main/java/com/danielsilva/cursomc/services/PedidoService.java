package com.danielsilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsilva.cursomc.domain.Pedido;
import com.danielsilva.cursomc.repositories.PedidoRepository;
import com.danielsilva.cursomc.services.exception.ObjectNotFoundExecption;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExecption(
		"Objeto não encontrado! Id:" + id + ", Tipo: "
		 + Pedido.class.getName()));
	}

}
