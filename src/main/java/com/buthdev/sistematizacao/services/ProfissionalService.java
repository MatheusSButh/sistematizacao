package com.buthdev.sistematizacao.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.buthdev.sistematizacao.domain.Clinica;
import com.buthdev.sistematizacao.domain.Profissional;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProfissionalService {
	
	private final String pathFile = "src/main/resources/profissionais.json";
	
	public List<Profissional> listAll(){
		return readFile().getProfissionais();
	}
	
	private Clinica readFile() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File(pathFile), Clinica.class);
		} catch (IOException e) {
			e.getMessage();
			return new Clinica();
		}
	}
}
