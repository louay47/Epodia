package org.epodia.services;

import java.util.List;

import org.epodia.entities.Pathological_genealogy;
import org.epodia.metier.PathologicalGenealogyMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PathologicalGenealogyRestService {
	
	@Autowired
	private PathologicalGenealogyMetier pathologicalGenealogyMetier ;

	@RequestMapping(value="/PG",method=RequestMethod.POST)
	public Pathological_genealogy saveP(@RequestBody Pathological_genealogy p) {
		return pathologicalGenealogyMetier.saveP(p);
	}

	@RequestMapping(value="/PG",method=RequestMethod.GET)
	public List<Pathological_genealogy> ListP() {
		return pathologicalGenealogyMetier.ListP();
	} 

}
