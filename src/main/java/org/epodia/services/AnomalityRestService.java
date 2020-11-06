package org.epodia.services;

import java.util.Collection;
import java.util.List;

import org.epodia.entities.Anomality;
import org.epodia.metier.AnomalityMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AnomalityRestService {
	
	@Autowired
	private AnomalityMetier anomalityMetier ;

	@RequestMapping(value="/anomalities",method=RequestMethod.POST)
	public Anomality saveAnomality(@RequestBody Anomality a) {
		return anomalityMetier.saveAnomality(a);
	}

	@RequestMapping(value="/anomalities",method=RequestMethod.GET)
	public List<Anomality> ListAnomalities() {
		return anomalityMetier.ListAnomalities();
	}

	@RequestMapping(value="/anomalities/patientAnom/{id}",method=RequestMethod.GET)
	public Collection<Anomality> patientAnomalitiesList(@PathVariable("id")Long id) {
		return anomalityMetier.patientAnomalitiesList(id);
	}
	
	

}
