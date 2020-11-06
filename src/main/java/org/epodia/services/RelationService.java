package org.epodia.services;

import java.util.List;

import org.epodia.entities.Relation;
import org.epodia.metier.RelationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RelationService {
	
	@Autowired
	private RelationMetier relationMetier ;

	@RequestMapping(value="/relations",method=RequestMethod.POST)
	public Relation saveRelation(@RequestBody Relation r) {
		return relationMetier.saveRelation(r);
	}

	@RequestMapping(value="/relations",method=RequestMethod.GET)
	public List<Relation> listRelation() {
		return relationMetier.listRelation();
	}

	@RequestMapping(value="/relations/{id}",method=RequestMethod.GET)
	public Relation getRelationById(@PathVariable("id") Long id) {
		return relationMetier.getRelationById(id);
	}

}
