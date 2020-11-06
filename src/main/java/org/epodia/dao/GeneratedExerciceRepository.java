package org.epodia.dao;


import java.util.Collection;


import org.epodia.entities.Generated_exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedExerciceRepository extends JpaRepository<Generated_exercice, Long>  {
	
	
	@Query(value="SELECT * FROM `generated_exercice` WHERE expert = :expert_id", nativeQuery = true)
	public Collection<Generated_exercice> ExpertGenExercice (Long expert_id);
}
