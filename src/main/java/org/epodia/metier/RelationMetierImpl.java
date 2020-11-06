package org.epodia.metier;

import java.util.List;

import org.epodia.dao.RelationRepository;
import org.epodia.entities.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationMetierImpl implements RelationMetier {

	@Autowired
	private RelationRepository relationRepository ;
	
	@Override
	public Relation saveRelation(Relation r) {
		// TODO Auto-generated method stub
		return relationRepository.save(r);
	}

	@Override
	public List<Relation> listRelation() {
		// TODO Auto-generated method stub
		return relationRepository.findAll();
	}

	@Override
	public Relation getRelationById(Long id) {
		// TODO Auto-generated method stub
		return relationRepository.getOne(id);
	}

}
