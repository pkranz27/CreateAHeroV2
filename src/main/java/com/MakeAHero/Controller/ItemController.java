package com.MakeAHero.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.MakeAHero.Model.Hero;
import com.MakeAHero.Model.Item;
import com.MakeAHero.Model.User;
import com.MakeAHero.Service.HeroService;
import com.MakeAHero.Service.ItemService;
import com.MakeAHero.Service.ProfessionService;
import com.MakeAHero.Service.UserService;
@Controller
public class ItemController {
	@Autowired
	ItemService itemService;
	@Autowired
	HeroService heroService;
	@Autowired
	UserService userService;
	@Autowired
	ProfessionService professionService;
	
	@GetMapping(value="/inventory")
	public String show( Model model, Long id, String profession, Hero currentHero) {
		// Grab the current hero 
		currentHero = heroService.findAllByUsers(id);
		//Instantiate  item list 
		List<Item> itemList=  itemService.findAll();
		//setCurrentHeroInventory 
		List<Item> heroInventory = heroService.updatePlayerInventory(itemList);
		//Display hero inventory
		model.addAttribute("heroInventory", heroInventory);
		//Set the Model to appear on web page
		
		//return
		return"inventory";
	}
	

	
	
	@ModelAttribute("list")
	public List<Double>list(){
		return new ArrayList<>();
	}
	
}
