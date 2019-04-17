package com.gagecottom.nationbuilder.repository;

import org.springframework.data.repository.CrudRepository;

import com.gagecottom.nationbuilder.message.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {

}
