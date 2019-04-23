package com.gagecottom.nationbuilder.repository;

import org.springframework.data.repository.CrudRepository;

import com.gagecottom.nationbuilder.war.WarDeclaration;

public interface WarRepository extends CrudRepository<WarDeclaration, Integer>{

}
