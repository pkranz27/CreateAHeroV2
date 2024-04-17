package com.MakeAHero.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CertificationController {
	@GetMapping(value="/certifications")
	public String getCertifications(){
		return"certifications";
	}
}
