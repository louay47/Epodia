package org.epodia.metier;

import java.util.Collection;
import java.util.List;

import org.epodia.dao.GeneratedExerciceRepository;
import org.epodia.entities.Generated_exercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratedExerciceMetierImpl implements GeneratedExerciceMetier {

	@Autowired
	private GeneratedExerciceRepository generatedExerciceRepository ; 
	
	@Override
	public Generated_exercice saveGeneratedExercice(Generated_exercice GE) {
		// TODO Auto-generated method stub
		return generatedExerciceRepository.save(GE);
	}

	@Override
	public List<Generated_exercice> ListGExerciceList() {
		// TODO Auto-generated method stub
		return generatedExerciceRepository.findAll();
	}

	@Override
	public Generated_exercice updateGExercice(Generated_exercice GE, Long id) {
		// TODO Auto-generated method stub
		return generatedExerciceRepository.saveAndFlush(GE);
	}

	@Override
	public Generated_exercice getGExerciceById(Long id) {
		// TODO Auto-generated method stub
		return generatedExerciceRepository.getOne(id);
	}

	@Override
	public Collection<Generated_exercice> ExpertGenExercice(Long id) {
		// TODO Auto-generated method stub
		return generatedExerciceRepository.ExpertGenExercice(id) ;
	}

	@Override
	public void deleteGExercice(Long id) {
		// TODO Auto-generated method stub
		
	}

}
