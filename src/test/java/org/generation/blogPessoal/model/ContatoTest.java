package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT )
public class ContatoTest {
	
	public Contato contato;
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	@BeforeEach
	public void start() {
		contato = new Contato(1,"Gabriel","011y","9xxxxxxx9");
	}
	
	@Test
	void testValidationAtributs() {
		contato.setNome("Julio");
		contato.setDdd("11");
		contato.setTelefone("31314141");
		
		Set<ConstraintViolation<Contato>> violations=validator
		.validate(contato);
		System.out.println(violations.toString());
		assertTrue(violations.isEmpty());
	}
}
