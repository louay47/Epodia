package org.epodia.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
//@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
@Proxy(lazy=false)
public class Affected_exercice implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id ;
		private int nbr_application ;
		private int repos ;
		private int duree ;
		private int duree_traitement ;
		private float frequence_traitement ;
		private int nbr_pas ;
		private int nbr_appui_gauche ;
		private int nbr_appui_droit ;
		private int stabilite ;
		private int pression_arterielle ;
		private int vitesse ;
		private int rythme;
		private int distance ;
		private boolean qualite_pression ;
		private int quantite_pression ;
		private Date date_affectation ;
		private boolean etat ;
		
		/*
		 * 
		 * OLD RELATION BETWEEN USER & AFFECTED_EXERCICE
		 * 
		 */
	/*@ManyToOne
	@JoinColumn(name="CODE_USER")
		private User users ;*/
		
		
	@ManyToOne
	@JoinColumn(name="GEN_EXERC")
		private Generated_exercice generated_exercice ;
	 
	/* * * * NEW RELATION BETWEEN EXPERT & AFFECTED_EXERCICE * * * * */
	 
	@ManyToOne
	@JoinColumn(name="CODE_EXPERT")
		private User experts ;
	
	/*
	 * 
	 * NEW RELATION BETWEEN DEVICE_USER & AFFECTED_EXERCICE
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="CODE_DUSER")
			private User dusers ;
	
	@OneToMany(mappedBy="affected_exercice",fetch=FetchType.LAZY)
			private Collection<Stats> stats ;

	public Affected_exercice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Affected_exercice(int nbr_application, int repos, int duree, int duree_traitement,
			float frequence_traitement, int nbr_pas, int nbr_appui_gauche, int nbr_appui_droit, int stabilite,
			int pression_arterielle, int vitesse, int rythme, int distance, boolean qualite_pression,
			int quantite_pression, Date date_affectation, boolean etat, Generated_exercice generated_exercice,
			User experts, User dusers, Collection<Stats> stats) {
		super();
		
		this.nbr_application = nbr_application;
		this.repos = repos;
		this.duree = duree;
		this.duree_traitement = duree_traitement;
		this.frequence_traitement = frequence_traitement;
		this.nbr_pas = nbr_pas;
		this.nbr_appui_gauche = nbr_appui_gauche;
		this.nbr_appui_droit = nbr_appui_droit;
		this.stabilite = stabilite;
		this.pression_arterielle = pression_arterielle;
		this.vitesse = vitesse;
		this.rythme = rythme;
		this.distance = distance;
		this.qualite_pression = qualite_pression;
		this.quantite_pression = quantite_pression;
		this.date_affectation = date_affectation;
		this.etat = etat;
		this.generated_exercice = generated_exercice;
		this.experts = experts;
		this.dusers = dusers;
		this.stats = stats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNbr_application() {
		return nbr_application;
	}

	public void setNbr_application(int nbr_application) {
		this.nbr_application = nbr_application;
	}

	public int getRepos() {
		return repos;
	}

	public void setRepos(int repos) {
		this.repos = repos;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getDuree_traitement() {
		return duree_traitement;
	}

	public void setDurée_traitement(int duree_traitement) {
		this.duree_traitement = duree_traitement;
	}

	public float getFrequence_traitement() {
		return frequence_traitement;
	}

	public void setFrequence_traitement(float frequence_traitement) {
		this.frequence_traitement = frequence_traitement;
	}

	public int getNbr_pas() {
		return nbr_pas;
	}

	public void setNbr_pas(int nbr_pas) {
		this.nbr_pas = nbr_pas;
	}

	public int getNbr_appui_gauche() {
		return nbr_appui_gauche;
	}

	public void setNbr_appui_gauche(int nbr_appui_gauche) {
		this.nbr_appui_gauche = nbr_appui_gauche;
	}

	public int getNbr_appui_droit() {
		return nbr_appui_droit;
	}

	public void setNbr_appui_droit(int nbr_appui_droit) {
		this.nbr_appui_droit = nbr_appui_droit;
	}

	public int getStabilite() {
		return stabilite;
	}

	public void setStabilite(int stabilite) {
		this.stabilite = stabilite;
	}

	public int getPression_arterielle() {
		return pression_arterielle;
	}

	public void setPression_arterielle(int pression_arterielle) {
		this.pression_arterielle = pression_arterielle;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getRythme() {
		return rythme;
	}

	public void setRythme(int rythme) {
		this.rythme = rythme;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isQualite_pression() {
		return qualite_pression;
	}

	public void setQualite_pression(boolean qualite_pression) {
		this.qualite_pression = qualite_pression;
	}

	public int getQuantite_pression() {
		return quantite_pression;
	}

	public void setQuantité_pression(int quantite_pression) {
		this.quantite_pression = quantite_pression;
	}

	public Date getDate_affectation() {
		return date_affectation;
	}

	public void setDate_affectation(Date date_affectation) {
		this.date_affectation = date_affectation;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Generated_exercice getGenerated_exercice() {
		return generated_exercice;
	}

	public void setGenerated_exercice(Generated_exercice generated_exercice) {
		this.generated_exercice = generated_exercice;
	}

	public User getExperts() {
		return experts;
	}

	public void setExperts(User experts) {
		this.experts = experts;
	}

	public User getDusers() {
		return dusers;
	}

	public void setDusers(User dusers) {
		this.dusers = dusers;
	}

	@JsonIgnore
	public Collection<Stats> getStats() {
		return stats;
	}

	@JsonSetter
	public void setStats(Collection<Stats> stats) {
		this.stats = stats;
	}
	

}
