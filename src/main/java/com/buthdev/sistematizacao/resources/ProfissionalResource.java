package com.buthdev.sistematizacao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buthdev.sistematizacao.domain.Profissional;
import com.buthdev.sistematizacao.services.ProfissionalService;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalResource {
	
	@Autowired
	private ProfissionalService proService;
	
	@GetMapping
	private ResponseEntity<List<Profissional>> listAll(){
		return ResponseEntity.ok().body(proService.listAll());
	}
	
	@GetMapping("/nome/{name}")
	private ResponseEntity<List<Profissional>> listByName(@PathVariable String name){
		return ResponseEntity.ok().body(proService.listByName(name));
	}
	
	@GetMapping("/especialidade/{speciality}")
	private ResponseEntity<List<Profissional>> listBySpeciality(@PathVariable String speciality){
		return ResponseEntity.ok().body(proService.listBySpeciality(speciality));
	}
}
