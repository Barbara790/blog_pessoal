package org.generation.blogPessoal.repositories;

import java.util.List;

import org.generation.blogPessoal.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	public Contato findFirstByNome(String nome);
	public List<Contato> findAllByNomeIgnoreCaseContaining(String nome);

}
