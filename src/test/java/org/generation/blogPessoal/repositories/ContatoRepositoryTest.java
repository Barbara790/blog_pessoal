package org.generation.blogPessoal.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.generation.blogPessoal.model.Contato;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContatoRepositoryTest {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@BeforeAll
	public void start() {
		Contato contato = new Contato(1, "Chefe", "0y", "9xxxxxxx9"); 
		if(contatoRepository.findFirstByNome(contato.getNome())==null)
			contatoRepository.save(contato);
		
		contato = new Contato(2, "Novo Chefe", "0y", "8xxxxxxx8");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null) 
			contatoRepository.save(contato); 
		
		contato = new Contato(3, "chefe Mais Antigo", "0y", "7xxxxxxx7"); 
		if (contatoRepository.findFirstByNome(contato.getNome()) == null) 
			contatoRepository.save(contato); 
		
		contato = new Contato(4, "Amigo", "0z", "5xxxxxxx5"); 
		if (contatoRepository.findFirstByNome(contato.getNome()) == null) 
			contatoRepository.save(contato); 
	}
	
	@Test
	public void findByNomeRetornaContato() throws Exception{
		Contato contato = contatoRepository.findFirstByNome("chefe");
		assertTrue(contato.getNome().equals("chefe"));
	}
	
	@Test
	public void findAllByNomeIgnoreCaseRetornaTresContatos() {
		List<Contato> contatos = contatoRepository
				.findAllByNomeIgnoreCaseContaining("chefe");
		assertEquals(3,contatos.size());
	}
	
	@AfterAll
	public void end() {
		contatoRepository.deleteAll();
	}
}
