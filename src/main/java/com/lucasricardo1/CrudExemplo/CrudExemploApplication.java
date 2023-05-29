package com.lucasricardo1.CrudExemplo;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.lucasricardo1.CrudExemplo")
public class CrudExemploApplication implements CommandLineRunner {


	@Autowired
	ContatoService contatoService;

	public static void main(String[] args) {
		SpringApplication.run(CrudExemploApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ContatoDTO contatoDTO = new ContatoDTO(null,"Lucas", "34997975509");
		ContatoDTO contatoDTO1 = new ContatoDTO(null, "teste", "333444");
		ContatoDTO contatoDTO2 = new ContatoDTO(null, "teste2", "444333");
		List<ContatoDTO> contatoDTOS = new ArrayList<>();
		contatoDTOS.add(contatoDTO1);
		contatoDTOS.add(contatoDTO2);

		contatoService.saveContact(contatoDTO);
		contatoService.saveContacts(contatoDTOS);
	}
}
