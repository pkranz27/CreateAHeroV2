package com.MakeAHero.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MakeAHero.Model.Message;
import com.MakeAHero.Model.User;
import com.MakeAHero.Service.UserService;

@Controller
public class MessageController {
	@Autowired
	public UserService userService;
	
	@GetMapping(value="/messages")
	public String getChat(@Payload Message message ,Model model){
		User currentUser = userService.getLoggedInUser();
		Iterable<User>userList = userService.getLoggedInUsers(currentUser.getId());
		model.addAttribute("message",message);
		model.addAttribute("currentuser",currentUser);
		model.addAttribute("userList",userList);
		return"messages";
	}
	@MessageMapping("/message.sendMessage")
	@SendTo("/topic/publicChatRoom")
	public Message sendMessage(@Payload Message message) {
		System.out.println(message); 		return message;
	}
	
	@MessageMapping("/message.addUser")
	@SendTo("/topic/publicChatRoom")
	public Message addUser(@Payload Message message,User user, SimpMessageHeaderAccessor headerAccessor) {
		 headerAccessor.getSessionAttributes().put("username", message.getSender());
		 return message;
	}
	
	 @GetMapping(value = "/logout")
	    public String logout(HttpServletRequest request) {
	        request.getSession(true).invalidate();
	        
	        return "redirect:/messages";
	    }
	

}
