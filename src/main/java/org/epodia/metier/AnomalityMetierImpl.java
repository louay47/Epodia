package org.epodia.metier;

import java.util.Collection;
import java.util.List;

import org.epodia.dao.AnomalityRepository;
import org.epodia.entities.Anomality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnomalityMetierImpl implements AnomalityMetier {

	@Autowired
	private AnomalityRepository anomalityRepository ;
	
	@Override
	public Anomality saveAnomality(Anomality a) {
		// TODO Auto-generated method stub
		return anomalityRepository.save(a);
	}

	@Override
	public List<Anomality> ListAnomalities() {
		// TODO Auto-generated method stub
		return anomalityRepository.findAll();
	}

	@Override
	public Collection<Anomality> patientAnomalitiesList(Long id) {
		// TODO Auto-generated method stub
		return anomalityRepository.patientAnomalitiesList(id);
	}

}
