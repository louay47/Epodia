package org.epodia.metier;

import java.util.List;

import org.epodia.entities.Pathological_genealogy;

public interface PathologicalGenealogyMetier {
	
	public Pathological_genealogy saveP(Pathological_genealogy p) ;
	
	public List<Pathological_genealogy> ListP();

}
