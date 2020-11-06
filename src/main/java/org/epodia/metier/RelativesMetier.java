package org.epodia.metier;

import java.util.List;

import org.epodia.entities.Relatives;

public interface RelativesMetier {
	
	public Relatives saveRelatives(Relatives r) ;
	
	public List<Relatives> ListRelatives() ;

}
