package com.gagecottom.nationbuilder.repository;

import org.springframework.data.repository.CrudRepository;

import com.gagecottom.nationbuilder.simulation.Turn;

public interface TurnRepository extends CrudRepository<Turn, Integer> {

}
