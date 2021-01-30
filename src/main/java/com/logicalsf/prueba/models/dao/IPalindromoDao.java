package com.logicalsf.prueba.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.logicalsf.prueba.models.entity.Palindromo;

public interface IPalindromoDao extends CrudRepository<Palindromo, Long>{

}
