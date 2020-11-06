package org.epodia.services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.epodia.model.AppResultMessage;

import org.epodia.entities.Affected_exercice;
import org.epodia.entities.Stats;
import org.epodia.metier.AffectedExerciceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping("/api/v1")
public class affectedExerciceService {
	@Autowired
	private AffectedExerciceMetier affectedExerciceMetier;

	

	@RequestMapping(value="/AffExercice/{id}",method=RequestMethod.DELETE)
	public void deleteAffExercice(@PathVariable("id") Long id) {
		affectedExerciceMetier.deleteAffExercice(id);
	}

	@RequestMapping(value="/AffExercice",method=RequestMethod.POST)
	public Affected_exercice saveAffectedExercice(@RequestBody Affected_exercice AE) {
		return affectedExerciceMetier.saveAffectedExercice(AE);
	}

	@RequestMapping(value="/AffExercice",method=RequestMethod.GET)
	public List<Affected_exercice> ListAffectedExercice() {
		return affectedExerciceMetier.ListAffectedExercice();
	}

	@RequestMapping(value="/AffExercice/{id}",method=RequestMethod.PUT)
	public Affected_exercice updateAffectedExercice(@RequestBody Affected_exercice AE,@PathVariable("id") Long id) {
		return affectedExerciceMetier.updateAffectedExercice(AE, id);
	}

	@RequestMapping(value="/AffExercice/{id}",method=RequestMethod.GET)
	public Affected_exercice getAffExerciceById(@PathVariable("id")Long id) {
		return affectedExerciceMetier.getAffExerciceById(id);
	}

	@RequestMapping(value="/AffExercice/expertAffExercice/{expert_id}",method=RequestMethod.GET)
	public Collection<Affected_exercice> ExpertAffExerciceList(@PathVariable("expert_id") Long expert_id)
	{
		return affectedExerciceMetier.ExpertAffExerciceList(expert_id);
	}
	/*
	@RequestMapping(value="/AffExercice/runExercice/{affexercice_id}",method=RequestMethod.GET)
	public String runExercice(@PathVariable("affexercice_id") Long affexercice_id) {
		return affectedExerciceMetier.runExercice(affexercice_id);
	}*/

	@RequestMapping(value="/AffExercice/patientAffExercice/{patient_id}",method=RequestMethod.GET)
	public Collection<Affected_exercice> PatientAffExerciceList(@PathVariable("patient_id") Long patient_id)
	{
		return affectedExerciceMetier.PatientAffExerciceList(patient_id);
	}
	
	
	@MessageMapping("/stats")
	@SendTo("/topic")
	public Stats addStat( Stats stats) {
				
		return affectedExerciceMetier.runExercice(stats);
	}
	
	@MessageMapping("/result")
	@SendTo("/topic")
	public AppResultMessage AppResult(Stats stats) {
		
		//AppResultMessage appResultMessage = new AppResultMessage();
		
		return affectedExerciceMetier.AppResult(stats);
	}
}
