package com.MakeAHero.Configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


import com.MakeAHero.interceptor.HttpHandshakeInterceptor;


@Configuration
@EnableWebSocketMessageBroker //This annotation tell with the Spring that "let's enable WebSocket Server".
public class WebSocketConfirguration implements WebSocketMessageBrokerConfigurer {

	// HttpHandshakeInterceptor class is used to handle events immediately before and after  WebSocket shakes hands with the HTTP. 

	@Autowired
	public HttpHandshakeInterceptor handShakeInterceptor;
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws")
			.setAllowedOriginPatterns("*")
			.withSockJS()
			.setClientLibraryUrl("https://cdn.jsdelivr.net/sockjs/1.0.0/sockjs.min.js");
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
	}
}
