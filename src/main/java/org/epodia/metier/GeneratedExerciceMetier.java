package org.epodia.metier;

import java.util.Collection;
import java.util.List;

import org.epodia.entities.Generated_exercice;

public interface GeneratedExerciceMetier {
	
	public Generated_exercice saveGeneratedExercice (Generated_exercice GE);
	
	public List<Generated_exercice> ListGExerciceList ();
	
	public Generated_exercice updateGExercice(Generated_exercice GE , Long id);
	
	public Generated_exercice getGExerciceById (Long id);
	
	public Collection<Generated_exercice> ExpertGenExercice (Long id);
	
	public void deleteGExercice(Long id);
	
	

}
