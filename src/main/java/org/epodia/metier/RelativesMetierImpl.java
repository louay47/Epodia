package org.epodia.metier;

import java.util.List;

import org.epodia.dao.RelativesRepository;
import org.epodia.entities.Relatives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelativesMetierImpl implements RelativesMetier {

	@Autowired
	private RelativesRepository relativesRepository ; 
	
	@Override
	public Relatives saveRelatives(Relatives r) {
		// TODO Auto-generated method stub
		return relativesRepository.save(r);
	}

	@Override
	public List<Relatives> ListRelatives() {
		// TODO Auto-generated method stub
		return relativesRepository.findAll();
	}

}
