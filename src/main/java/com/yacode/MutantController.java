package com.yacode;

import com.yacode.model.MutantRequest;
import com.yacode.model.MutantResponse;
import com.yacode.model.MutantValidation;
import com.yacode.model.StatsResponse;
import com.yacode.service.Stats;
import com.yacode.service.StatsService;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/api/mutantes"})

public class MutantController {

	@Autowired
	StatsService servicio;
	
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	@GetMapping
	public StatsResponse stats(){
		
		StatsResponse response = new StatsResponse();				
		response = servicio.listar();		
		return response;
		
	}	
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/mutant", method = RequestMethod.POST)
	@PostMapping
	public MutantResponse mutant(@RequestBody MutantRequest p) throws IOException {
		
		boolean isMutant;
		HttpResponse response = null;
		
		MutantValidation validacion = new MutantValidation();
		MutantResponse resp = new MutantResponse();
		Stats stats = new Stats();
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
		isMutant = validacion.validarAdn(p.getDna());
		
		String cadena = "";
		for(int i = 0;i<p.getDna().length;i++) {
			cadena = cadena+ p.getDna()[i];
		}				
		
		if (isMutant) {
			resp.setCodigo(200);
			resp.setMensaje("Es Mutante");
			
			stats.setCadena(cadena);
			stats.setResultado("Mutante");
			servicio.add(stats);
		}else {
			resp.setCodigo(401);
			resp.setMensaje("Es Humano");
			
			stats.setCadena(cadena);
			stats.setResultado("Humano");
			servicio.add(stats);
		}
		
		 return resp;
	}
	
		
}
