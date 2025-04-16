package com.buthdev.sistematizacao.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Profissional> listByName(String name){
		return listAll().stream().filter(x -> x.getNome().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
	}
	
	public List<Profissional> listBySpeciality(String speciality){
		return listAll().stream().filter(x -> x.getEspecialidade().toLowerCase().contains(speciality.toLowerCase())).collect(Collectors.toList());
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
