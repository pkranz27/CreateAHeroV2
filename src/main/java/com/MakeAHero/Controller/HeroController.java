

package com.MakeAHero.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.MakeAHero.Model.Hero;
import com.MakeAHero.Model.Profession;
import com.MakeAHero.Model.Race;
import com.MakeAHero.Model.User;
import com.MakeAHero.Service.HeroService;
import com.MakeAHero.Service.ProfessionService;
import com.MakeAHero.Service.RaceService;
import com.MakeAHero.Service.UserService;

@Controller
@ControllerAdvice
public class HeroController {
	
	

	@Autowired
    private HeroService heroService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private RaceService raceService;
	
	@Autowired
	private ProfessionService professionService;
	
	@GetMapping(value="/heropage")
	public String create(Model model, @Valid Race race, @Valid Profession profession){
	    Hero hero = new Hero();
	    model.addAttribute("hero", hero);
	    List<Race> raceList = raceService.findAll();
	    raceList.toString();
		model.addAttribute("raceList", raceList);
		 List<Profession> professionList = professionService.findAll();
		 professionList.toString();
		model.addAttribute("professionList", professionList);
		System.out.println("------------------=============-------------===============--------"+professionList);
	    return "heropage";
	}

	@PostMapping(value = "/create")
	public String createHero(@Valid Hero hero,BindingResult bindingResult,  Race race, Profession profession, Model model) {
		
		if(!bindingResult.hasErrors()) {
			User user = userService.getLoggedInUser();
			hero.setUser(user);
			hero.setRace(race);
			hero.setProfession(profession);
			model.addAttribute("hero", new Hero());
			heroService.saveNewHero(hero);
			return "redirect:/";
		}
		return "heropage";
	}	
}
