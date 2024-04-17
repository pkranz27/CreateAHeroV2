package com.MakeAHero.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MakeAHero.Model.Profession;
import com.MakeAHero.Repository.ProfessionRepository;
@Service
public class ProfessionService {
	@Autowired
	ProfessionRepository professionRepository;
	
	
	public List<Profession> findAll(){
	    return (List<Profession>) professionRepository.findAll();
	}
	 public Profession findById(long id) {
		 return professionRepository.findById(id);
	 }
}
