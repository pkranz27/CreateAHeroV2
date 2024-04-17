package com.MakeAHero.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class HttpHandshakeInterceptor implements HandshakeInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(HandshakeInterceptor.class);
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		logger.info("Call before Handshake");
		
		if(request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest =(ServletServerHttpRequest)request;
			HttpSession session = servletRequest.getServletRequest().getSession();
			attributes.put("sessionid", session.getId());
			logger.info("Call Made "+session+" :" + request);
			System.out.println("This is the Sesssion:--------->"+  session);
		}
		return false;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		logger.info("Call After Handshake");
		
	}

}
