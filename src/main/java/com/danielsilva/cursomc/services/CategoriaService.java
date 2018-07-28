package com.danielsilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.danielsilva.cursomc.domain.Categoria;
import com.danielsilva.cursomc.repositories.CategoriaRepository;
import com.danielsilva.cursomc.services.exception.DataIntegrationExecption;
import com.danielsilva.cursomc.services.exception.ObjectNotFoundExecption;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExecption(
				"Objeto não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DataIntegrationExecption("Não é possível excluir uma categoria que possui produtos");
		}

	}

}
