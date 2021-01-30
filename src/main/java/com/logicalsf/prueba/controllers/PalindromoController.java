package com.logicalsf.prueba.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logicalsf.prueba.exceptions.BadStringException;
import com.logicalsf.prueba.models.dto.Cadena;
import com.logicalsf.prueba.models.entity.Palindromo;
import com.logicalsf.prueba.models.service.IPalindromoService;

@CrossOrigin(origins = {"http://localhost:4200", "**", "*"})
@RestController
@RequestMapping(value = "/api/v1/palindromos")
public class PalindromoController {

	
	@Autowired
	private IPalindromoService palindromoService;
	
	
	@GetMapping(value = "/validar")
	public ResponseEntity<?> validar(){
		
		return ResponseEntity.status(HttpStatus.OK).body("Hola");
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listar(){
		
		Map<String, Object> response = new HashMap<>();
		List<Palindromo> resultados = new ArrayList<>();
		
		try {
			resultados = palindromoService.findAll();
			response.put("resultados", resultados);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch (Exception e) {
			response.put("message", "Ocurrio un error al intentar obtener los resultados");
			response.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		
	}
	
	@PostMapping(value = "/crear")
	public ResponseEntity<?> crear(@RequestBody Cadena cadena){
		
		Palindromo palindromo = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			palindromo = palindromoService.validar(cadena);
			response.put("text", palindromo.getInvertido());
			response.put("palindromo", palindromo.isPalindromo());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(BadStringException e) {
			response.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}catch(Exception e) {
			response.put("message", "Ocrurrio un error interno");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
		
		
		
	}
	
	
	
	
	
}
