package org.epodia.dao;

import java.util.Collection;

import org.epodia.entities.Anomality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnomalityRepository extends JpaRepository<Anomality, Long>  {

	@Query (value="SELECT * FROM `Anomality` WHERE patient_id = :patient_id", nativeQuery = true)
	public Collection<Anomality> patientAnomalitiesList (Long patient_id);
}
