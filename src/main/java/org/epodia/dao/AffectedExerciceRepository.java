package org.epodia.dao;

import java.util.Collection;

import org.epodia.entities.Affected_exercice;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectedExerciceRepository extends JpaRepository<Affected_exercice, Long>  {

	
	@Query(value="SELECT * FROM `affected_exercice` WHERE code_expert= :expert_id", nativeQuery = true)
	public Collection<Affected_exercice> ExpertAffExerciceList (@Param(value="expert_id") Long expert_id );
	
	
	
	@Query(value="SELECT * FROM `affected_exercice` WHERE code_expert= :patient_id", nativeQuery = true)
	public Collection<Affected_exercice> PatientAffExerciceList (@Param(value="patient_id") Long patient_id );
}
