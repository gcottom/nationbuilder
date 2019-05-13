package com.gagecottom.nationbuilder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gagecottom.nationbuilder.repository.TurnRepository;
import com.gagecottom.nationbuilder.simulation.Turn;

@Service
public class TurnService {
@Autowired
private TurnRepository turnRepository;
public Turn findById(int id) {
	Turn newTurn = new Turn();
	Optional<Turn> turn = turnRepository.findById(id);
	Optional<Integer> turnId = turn.map(Turn::getId);
	int newId = turnId.get();
	Optional<Integer> turnNum = turn.map(Turn::getTurn);
	int newTurnNum = turnNum.get();
	newTurn.setId(newId);
	newTurn.setTurn(newTurnNum);
	return newTurn;
}
public void saveTurn(Turn turn) {
	turnRepository.save(turn);
}
public boolean existsById(int id) {
	return turnRepository.existsById(id);
}
public void deleteAll() {
	turnRepository.deleteAll();
}
}
