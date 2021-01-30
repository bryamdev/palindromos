package com.logicalsf.prueba.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.logicalsf.prueba.exceptions.BadStringException;
import com.logicalsf.prueba.models.dao.IPalindromoDao;
import com.logicalsf.prueba.models.dto.Cadena;
import com.logicalsf.prueba.models.entity.Palindromo;
import com.logicalsf.prueba.models.service.IPalindromoService;

@Service
public class PalindromoServiceImpl implements IPalindromoService{

	@Autowired
	private IPalindromoDao palindromoDao;
	
	
	@Override
	public List<Palindromo> findAll() {
		// TODO Auto-generated method stub
		return (List<Palindromo>) palindromoDao.findAll();
	}

	@Override
	public Palindromo save(Palindromo palindromo) {
		// TODO Auto-generated method stub
		return palindromoDao.save(palindromo);
	}

	@Override
	public Palindromo validar(Cadena cadena) throws BadStringException {

		String cadenaTexto = cadena.getText();
		
		if(cadenaTexto.isEmpty()) {
			throw new BadStringException("Debe proporcionar una cadena");
		}
		
		for(char c : cadenaTexto.toCharArray()) {
			if(Character.isDigit(c)) {
				throw new BadStringException("La candena no puede contener números");
			}
		}
		
		Palindromo palindromo = new Palindromo();
		palindromo.setCadena(cadena.getText());
		palindromo.setInvertido(invertirCadena(cadenaTexto));
		palindromo.setPalindromo(verificarPalindromo(cadenaTexto));
		
		
		Palindromo newPalindromo = save(palindromo);
		
		return newPalindromo;
	}

	@Override
	public boolean verificarPalindromo(String cadena) {
		
		String cadenaJoined = cadena.replace(" ", "");
		String cadenaInvertida = invertirCadena(cadena).replace(" ", "");
				
		return cadenaJoined.equalsIgnoreCase(cadenaInvertida);
	}

	@Override
	public String invertirCadena(String cadena) {

		StringBuilder builder = new StringBuilder(cadena);
		String cadenaInvertida = builder.reverse().toString();
		
		return cadenaInvertida;
	}
	
	
	
	
	
	

}
