package com.gagecottom.nationbuilder.repository;

import org.springframework.data.repository.CrudRepository;

import com.gagecottom.nationbuilder.nation.Nation;

public interface NationRepository extends CrudRepository<Nation, Integer> {

}
