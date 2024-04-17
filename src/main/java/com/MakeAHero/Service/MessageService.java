package com.MakeAHero.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MakeAHero.Model.Message;
import com.MakeAHero.Repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	public MessageRepository messageRepository;
	
	
	
	public void save(Message message) {
	    messageRepository.save(message);
	}

}
