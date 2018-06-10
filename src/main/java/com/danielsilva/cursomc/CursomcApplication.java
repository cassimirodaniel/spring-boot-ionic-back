package com.danielsilva.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danielsilva.cursomc.domain.Categoria;
import com.danielsilva.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository  CatagoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");
		
		CatagoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		
		
	}
	
	
}
