package org.epodia.services;

import java.util.Collection;
import java.util.List;

import org.epodia.entities.Generated_exercice;
import org.epodia.metier.GeneratedExerciceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GenExerciceService {
	
	@Autowired
	private GeneratedExerciceMetier generatedExerciceMetier ;

	@RequestMapping(value="/GenExercice",method=RequestMethod.POST)
	public Generated_exercice saveGeneratedExercice(@RequestBody Generated_exercice GE) {
		return generatedExerciceMetier.saveGeneratedExercice(GE);
	}

	@RequestMapping(value="/GenExercice/{id}",method=RequestMethod.DELETE)
	public void deleteGExercice(@PathVariable("id") Long id) {
		generatedExerciceMetier.deleteGExercice(id);
	}

	@RequestMapping(value="/GenExercice",method=RequestMethod.GET)
	public List<Generated_exercice> ListGExerciceList() {
		return generatedExerciceMetier.ListGExerciceList();
	}

	@RequestMapping(value="/GenExercice/{id}",method=RequestMethod.PUT)
	public Generated_exercice updateGExercice(@RequestBody Generated_exercice GE,@PathVariable("id") Long id) {
		return generatedExerciceMetier.updateGExercice(GE, id);
	}

	@RequestMapping(value="/GenExercice/{id}",method=RequestMethod.GET)
	public Generated_exercice getGExerciceById(@PathVariable("id") Long id) {
		return generatedExerciceMetier.getGExerciceById(id);
	}
	
	@RequestMapping(value="/GenExercice/ExpertGenExercice/{id}",method=RequestMethod.GET)
	public Collection<Generated_exercice> ExpertGenExercice(@PathVariable("id")Long id) {
		return generatedExerciceMetier.ExpertGenExercice(id) ;
	}

}
