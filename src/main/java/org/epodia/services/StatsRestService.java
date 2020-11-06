package org.epodia.services;

import java.util.Collection;

import org.epodia.entities.Stats;
import org.epodia.metier.StatsMetier;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StatsRestService {

	@Autowired
	private StatsMetier statsMetier;

	

	@RequestMapping(value="/stats/{id}",method=RequestMethod.GET)
	public Stats getStatsById(@PathVariable("id") Long id) {
		return statsMetier.getStatsById(id);
	}

	@RequestMapping(value="/stats",method=RequestMethod.GET)
	public Collection<Stats> getAllStats() {
		return statsMetier.getAllStats();
	}

	//@RequestMapping(value="/stats",method=RequestMethod.POST)
		/*@MessageMapping("/stats")
		@SendTo("/topic/result")
		public Stats addStat( Stats stats) {
			
			return statsMetier.addStats(stats);
		}*/
	
	
	/*@RequestMapping(value="/stats",method=RequestMethod.POST)
	public Stats addStats(@RequestBody Stats stats) {
		return statsMetier.addStats(stats);
	}*/

	@RequestMapping(value="/stats",method=RequestMethod.PUT)
	public Stats updateStats(@RequestBody Stats stats) {
		return statsMetier.updateStats(stats);
	}

	@RequestMapping(value="/stats/{id}",method=RequestMethod.DELETE)
	public void deleteStats(@PathVariable("id")  Long id) {
		statsMetier.deleteStats(id);
	}

	@RequestMapping(value="/stats/LatestStat/{id}",method=RequestMethod.GET)
	public Stats getDuserStatsList(@PathVariable("id")Long id) {
		return statsMetier.getDuserStatsList(id);
	}
	
	@RequestMapping(value="/stats/appNumber/{affExercice_id}",method=RequestMethod.GET)
	public int getAppnumber(@PathVariable("affExercice_id") Long id) {
		return statsMetier.getAppnumber(id);
	}
	
	@RequestMapping(value="/stats/lastAppStats/{app_number}/{id}",method=RequestMethod.GET)
	public Collection<Stats> getLastAppStats(@PathVariable("app_number") int app_number, @PathVariable("id") Long id) {
		return statsMetier.getLastAppStats(app_number, id);
	}
}
