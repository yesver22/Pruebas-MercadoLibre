package com.yacode.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.yacode.model.StatsResponse;
import com.yacode.repository.StatsRepository;

@Service
public class StatsServiceImp implements StatsService{
	
	@Autowired
	private StatsRepository repositorio;
	
	@Override
	public StatsResponse listar() {
		StatsResponse response = new StatsResponse();		
		List<Stats> lista = new ArrayList<>();
		DecimalFormat format = new DecimalFormat("0.00");
		
		Double cantHumano = 0.0;
		Double cantMutante = 0.0;
		Double ratio;
	
		lista = repositorio.findAll();
		
		List<Stats> humanos = lista.stream()
				.filter(p -> p.getResultado().equals("Humano"))
				.collect(Collectors.toList());
		

		List<Stats> mutantes = lista.stream()
				.filter(p -> p.getResultado().equals("Mutante"))
				.collect(Collectors.toList());
		
		cantHumano = (double) humanos.size();
		cantMutante = (double) mutantes.size();
		
		if(cantHumano > cantMutante) {
			
			ratio = (cantMutante/cantHumano);
			
		}else {
			ratio = (cantHumano/cantMutante);			
		}
		
		String rat = format.format(ratio);
		
		response.setCount_human_dna(cantHumano.intValue());
		response.setCount_mutant_dna(cantMutante.intValue());
		response.setRatio(rat);
		
		return response;
	}
	@Override
	public Stats add(Stats p) {
		// TODO Auto-generated method stub
		return repositorio.save(p);
	}	
}
