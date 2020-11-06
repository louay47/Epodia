package org.epodia.metier;

import java.util.Collection;
import java.util.List;

import org.epodia.dao.AffectedExerciceRepository;
import org.epodia.dao.StatsRepository;

import org.epodia.entities.Affected_exercice;
import org.epodia.entities.Stats;
import org.epodia.model.AppResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AffectedExerciceMetierImpl implements AffectedExerciceMetier {

	@Autowired
	private AffectedExerciceRepository affectedExerciceRepository ;
	
	
	@Override
	public Affected_exercice saveAffectedExercice(Affected_exercice AE) {
		// TODO Auto-generated method stub
		return affectedExerciceRepository.save(AE);
	}

	@Override
	public List<Affected_exercice> ListAffectedExercice() {
		// TODO Auto-generated method stub
		return affectedExerciceRepository.findAll();
	}

	@Override
	public Affected_exercice updateAffectedExercice(Affected_exercice AE ,Long id) {
		// TODO Auto-generated method stub
		return affectedExerciceRepository.saveAndFlush(AE);
	}

	@Override
	public Affected_exercice getAffExerciceById(Long id) {
		// TODO Auto-generated method stub
		return affectedExerciceRepository.getOne(id);
	}
	@Override
	public Collection<Affected_exercice> ExpertAffExerciceList(Long expert_id) {
		// TODO Auto-generated method stub
		return affectedExerciceRepository.ExpertAffExerciceList(expert_id);
	}

	@Override
	public Collection<Affected_exercice> PatientAffExerciceList(Long patient_id) {
		// TODO Auto-generated method stub
		return affectedExerciceRepository.PatientAffExerciceList(patient_id);
	}

	@Override
	public void deleteAffExercice(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Autowired
	StatsRepository statsRepository;
	
	@Override
	public Stats runExercice(Stats s) {
	
		
	
		return statsRepository.save(s);
		
		// TODO Auto-generated method stub
	/*	Affected_exercice affExercice = getAffExerciceById(s.getAffected_exercice().getId_exercice_aff()) ;
		Collection<Stats> statistics = statsRepository.getAffExerciceList(s.getAffected_exercice().getId_exercice_aff());
		
		
		
			int nbr_pas = 0;
			int nbr_appui_gauche = 0;
			int nbr_appui_droit = 0 ;
			int pression_arterielle = 0;
			int vitesse = 0;
			int distance = 0;
			int rythme = 0;
			
		for (Stats stats : statistics) {
			nbr_pas = nbr_pas + stats.getNbr_pas();
			nbr_appui_gauche = nbr_appui_gauche + stats.getNbr_appui_gauche();
			nbr_appui_droit = nbr_appui_droit + stats.getNbr_appui_droit() ;
			pression_arterielle = pression_arterielle + stats.getPression_arterielle() ;
			vitesse = vitesse + stats.getVitesse() ;
			distance = distance + stats.getDistance();
			rythme = rythme + stats.getRythme();
			
		}
		
		if(
				nbr_pas >= affExercice.getNbr_pas() 
				&& distance >= affExercice.getDistance()
				&& nbr_appui_droit >= affExercice.getNbr_appui_droit()
				&& nbr_appui_gauche >= affExercice.getNbr_appui_gauche()
				&& pression_arterielle >= affExercice.getPression_arterielle()
				&& rythme >= affExercice.getRythme()
				&& vitesse >= affExercice.getVitesse()
				
					) {
				res ="Done" ; 
				return res ;
					}
		else 
			
				res = "keep going";

		return res;*/
		
	}

	
	
	@Override
	@Transactional
	public AppResultMessage  AppResult (Stats stats) 
	{
		
		System.out.println("affacted exercice id: "+stats.getAffected_exercice().getId());
		
		 Affected_exercice affExercice = getAffExerciceById(stats.getAffected_exercice().getId());
		
		System.out.println("affeceted exercice steps nbr "+this.affectedExerciceRepository.getOne(stats.getAffected_exercice().getId()).getNbr_pas());
	
		Collection<Stats> statistics = statsRepository.getLastAppStats(stats.getApp_number(), stats.getAffected_exercice().getId()) ;
		
		int nbr_pas = 0;
		int nbr_appui_gauche = 0;
		int nbr_appui_droit = 0 ;
		int pression_arterielle = 0;
		int vitesse = 0;
		int distance = 0;
		int rythme = 0;
		 	
		for (Stats s : statistics) {
			nbr_pas = nbr_pas + s.getNbr_pas();
			nbr_appui_gauche = nbr_appui_gauche + s.getNbr_appui_gauche();
			nbr_appui_droit = nbr_appui_droit + s.getNbr_appui_droit() ;
			pression_arterielle = pression_arterielle + s.getPression_arterielle() ;
			vitesse = vitesse + s.getVitesse() ;
			distance = distance + s.getDistance();
			rythme = rythme + s.getRythme();
			
		}
		System.out.println(nbr_pas+" "+nbr_appui_gauche+" "+nbr_appui_droit);
		
		String res = "";
		
			if(
				nbr_pas >= affExercice.getNbr_pas() 
			/*	&& distance >= affExercice.getDistance()
				&& nbr_appui_droit >= affExercice.getNbr_appui_droit()
				&& nbr_appui_gauche >= affExercice.getNbr_appui_gauche()
				&& pression_arterielle >= affExercice.getPression_arterielle()
				&& rythme >= affExercice.getRythme()
				&& vitesse >= affExercice.getVitesse()*/) {
			
				res = "GOOD JOB" ;
				System.out.println("gg mf");
				
				
		}
		else {
			res = "TRY AGAIN" ;
			System.out.println("try again");
		}
			
			AppResultMessage appResultMessage = new AppResultMessage() ;
			
			appResultMessage.setContent(res);
			
			return appResultMessage;

	}
}
