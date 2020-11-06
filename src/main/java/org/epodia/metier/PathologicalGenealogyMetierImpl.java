package org.epodia.metier;

import java.util.List;

import org.epodia.dao.PathologicalGenealogyRepository;
import org.epodia.entities.Pathological_genealogy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathologicalGenealogyMetierImpl implements PathologicalGenealogyMetier {

	@Autowired
	private PathologicalGenealogyRepository pathologicalGenealogyRepository;
	
	@Override
	public Pathological_genealogy saveP(Pathological_genealogy p) {
		// TODO Auto-generated method stub
		return pathologicalGenealogyRepository.save(p);
	}

	@Override
	public List<Pathological_genealogy> ListP() {
		// TODO Auto-generated method stub
		return pathologicalGenealogyRepository.findAll();
	}

}
