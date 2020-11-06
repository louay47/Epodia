package org.epodia.metier;

import java.util.Collection;

import org.epodia.entities.Stats;



public interface StatsMetier {
	
	public Stats getStatsById(Long id);
	
	public Collection<Stats> getAllStats();
	
	public Stats addStats(Stats stats);
	
	public Stats updateStats(Stats stats);
	
	public void deleteStats(Long id);
	
	public Stats getDuserStatsList( Long id );
	
	public Collection<Stats> getAffExerciceList (Long id);
	
	public int getAppnumber ( Long id) ;
	
	public Collection<Stats> getLastAppStats ( int app_number , Long id ) ;



}
