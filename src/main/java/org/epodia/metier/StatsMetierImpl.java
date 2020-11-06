package org.epodia.metier;

import java.util.Collection;

import org.epodia.dao.StatsRepository;
import org.epodia.entities.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsMetierImpl implements StatsMetier {

	@Autowired
	private StatsRepository statsRepository ;
	
	@Override
	public Stats getStatsById(Long id) {
		// TODO Auto-generated method stub
		return statsRepository.getOne(id);
	}

	@Override
	public Collection<Stats> getAllStats() {
		// TODO Auto-generated method stub
		return statsRepository.findAll();
	}

	@Override
	public Stats addStats(Stats stats) {
		// TODO Auto-generated method stub
		return statsRepository.save(stats);
	}

	@Override
	public Stats updateStats(Stats stats) {
		
		return this.statsRepository.saveAndFlush(stats);
	}

	@Override
	public void deleteStats(Long id) {
		// TODO Auto-generated method stub
		this.statsRepository.deleteById(id);
	}
	

	@Override
	public Stats getDuserStatsList(Long id) {
		// TODO Auto-generated method stub
		return statsRepository.getDuserStatsList(id);
	}

	@Override
	public Collection<Stats> getAffExerciceList(Long id) {
		// TODO Auto-generated method stub
		return statsRepository.getAffExerciceList(id);
	}

	@Override
	public int getAppnumber(Long id) {

		int nbr = 0;
		
		try {
			nbr = statsRepository.getAppnumber(id);
		} catch (Exception e) {
			System.out.println("problem here !");
			nbr = 0;
		}
		
		return nbr;
	}

	@Override
	public Collection<Stats> getLastAppStats(int app_number, Long id) {
		// TODO Auto-generated method stub
		return statsRepository.getLastAppStats(app_number, id);
	}

}
