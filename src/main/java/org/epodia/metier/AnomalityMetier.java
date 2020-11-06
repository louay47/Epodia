package org.epodia.metier;

import java.util.Collection;
import java.util.List;

import org.epodia.entities.Anomality;

public interface AnomalityMetier {
	
	public Anomality saveAnomality(Anomality a) ;
	
	public List<Anomality> ListAnomalities();
	
	public Collection<Anomality> patientAnomalitiesList (Long id);
	

}
