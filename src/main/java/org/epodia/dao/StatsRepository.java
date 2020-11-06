package org.epodia.dao;


import java.util.Collection;

import org.epodia.entities.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
	
	/*
	 * 
	 * 
	 * get the latest stat of this device user
	 * 
	 */
	@Query(value="SELECT * FROM `stats` WHERE id = (SELECT MAX(id) FROM `stats` WHERE code_duser = :id)", nativeQuery = true)
	public Stats getDuserStatsList (@Param(value = "id") Long id);
	
	/*
	 * 
	 * get list of stats of this affected_exercice
	 * 
	 */
	@Query(value="SELECT * FROM `stats` WHERE code_affex IN ( SELECT code_affex FROM `stats` WHERE code_affex = :id )", nativeQuery = true)
	public Collection<Stats> getAffExerciceList (@Param(value = "id") Long id);
	/*
	 * 
	 * get last application number of this affected exercice 
	 * 
	 */
	
	@Query(value="SELECT MAX(app_number) FROM `stats` WHERE code_affex = :id", nativeQuery = true)
	public int getAppnumber (@Param(value = "id") Long id) ;
	
	/*
	 * 
	 * get list of stats of the last application of this affected exercice
	 * 
	 */
	@Query(value="SELECT * FROM `stats` WHERE code_affex = :id AND app_number = :app_number", nativeQuery = true)
	public Collection<Stats> getLastAppStats (@Param(value = "app_number") int app_number ,@Param(value = "id") Long id ) ;
}

