package org.epodia.metier;

import java.util.Collection;
import java.util.List;


import org.epodia.entities.Affected_exercice;
import org.epodia.entities.Stats;
import org.epodia.model.AppResultMessage;


public interface AffectedExerciceMetier {
	
	public Affected_exercice saveAffectedExercice(Affected_exercice AE);
	
	public List<Affected_exercice> ListAffectedExercice () ; 
	
	public Affected_exercice updateAffectedExercice (Affected_exercice AE , Long id);
	
	public Affected_exercice getAffExerciceById (Long id);
	
	public Collection<Affected_exercice> ExpertAffExerciceList (Long expert_id );
	
	public Collection<Affected_exercice> PatientAffExerciceList (Long patient_id );
	
	public void deleteAffExercice (Long id);
	
	public Stats runExercice (Stats stats);
	
	public AppResultMessage AppResult (Stats stats) ;
	
	
}
