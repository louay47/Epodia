package org.epodia.metier;

import java.util.List;

import org.epodia.entities.Relation;

public interface RelationMetier {
	
	public Relation saveRelation(Relation r);
	
	public List<Relation> listRelation();
	
	public Relation getRelationById(Long id);
	
	

}
