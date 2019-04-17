package com.gagecottom.nationbuilder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.gagecottom.nationbuilder.message.Message;
import com.gagecottom.nationbuilder.model.User;
import com.gagecottom.nationbuilder.repository.MessageRepository;

@Service
public class MessageService {
@Autowired
MessageRepository messageRepository;
@Autowired
UserService userService;
public void saveMessage(Message message) {
	messageRepository.save(message);
}
public List<Message> findMessagesByNationId(int id){
	List<Message> messages = new ArrayList<>();
	messageRepository.findAll().forEach(messages::add);
	String username;
	Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
	
	User user=userService.findByUsername(username);
	List<Message> newMessages = new ArrayList<>();
	for(int i = 0; i<messages.size(); i++) {
		if(messages.get(i).getReceiverId()==user.getId()) {
			newMessages.add(messages.get(i));
		}
	}
	return newMessages;
	
}
}
