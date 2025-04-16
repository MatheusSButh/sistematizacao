package com.buthdev.sistematizacao.domain;

import java.util.ArrayList;
import java.util.List;

public class Clinica {
	
	private List<Profissional> profissionais = new ArrayList<>();
	
	public Clinica() {
	}

	public Clinica(List<Profissional> profissionais) {
		super();
		this.profissionais = profissionais;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}
}
