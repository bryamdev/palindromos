package com.logicalsf.prueba.models.service;

import java.util.List;

import com.logicalsf.prueba.exceptions.BadStringException;
import com.logicalsf.prueba.models.dto.Cadena;
import com.logicalsf.prueba.models.entity.Palindromo;

public interface IPalindromoService {

	
	public List<Palindromo> findAll();
	
	public Palindromo save(Palindromo palindromo);
	
	public Palindromo validar(Cadena cadena)  throws BadStringException ;
	
	public boolean verificarPalindromo(String cadena);
	
	public String invertirCadena(String cadena);
	
}
