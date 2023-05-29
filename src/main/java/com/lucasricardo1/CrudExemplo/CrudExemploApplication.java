package com.lucasricardo1.CrudExemplo;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.services.ContatoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("com.lucasricardo1.CrudExemplo.mappers")
public class CrudExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudExemploApplication.class, args);
	}

}
