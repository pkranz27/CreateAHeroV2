package com.MakeAHero.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.MakeAHero.Model.Message;
import com.MakeAHero.Model.User;
import com.MakeAHero.Service.UserService;

public class WebSocketEventListener {
	private static Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		logger.info("received a new web socket connection");
	}
	
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		User username= (User)headerAccessor.getSessionAttributes();
		if(username != null) {
			logger.info("User Disconnected"+ username);
			Message chatMessage = new Message();
			chatMessage.setType(Message.MessageType.LEAVE);
			chatMessage.setUser(username);
			messagingTemplate.convertAndSend("/topic/publicChatRoom", chatMessage);
		}
	}
}
