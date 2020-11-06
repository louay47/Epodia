package org.epodia.services;

import java.util.List;

import org.epodia.entities.Relatives;
import org.epodia.metier.RelativesMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RelativesRestService  {
	
	@Autowired
	private RelativesMetier relativesMetier ;

	@RequestMapping(value="/relatives",method=RequestMethod.POST)
	public Relatives saveRelatives(@RequestBody Relatives r) {
		return relativesMetier.saveRelatives(r);
	}

	@RequestMapping(value="/relatives",method=RequestMethod.GET)
	public List<Relatives> ListRelatives() {
		return relativesMetier.ListRelatives();
	} 

}
