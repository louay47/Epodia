package org.epodia.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Stats implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		private int stability ;
		private int nbr_pas ;
		private int nbr_appui_gauche ;
		private int nbr_appui_droit ;
		private int vitesse ;
		private int rythme;
		private int distance ;
		private boolean qualite_pression ;
		private int quantite_pression ;
		private int pression_arterielle ;
		private Date temps ;
		private int app_number ;
	
	@ManyToOne
	@JoinColumn(name="CODE_AffEX")
		private Affected_exercice affected_exercice ;
	@ManyToOne
	@JoinColumn(name="CODE_DUSER")
		private Device_user device_user ;
	public Stats() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stats(int stability, int nbr_pas, int nbr_appui_gauche, int nbr_appui_droit, int vitesse,
			int rythme, int distance, boolean qualite_pression, int quantite_pression, int pression_arterielle,
			Date temps, int app_number, Affected_exercice affected_exercice, Device_user device_user) {
		super();
		
		this.stability = stability;
		this.nbr_pas = nbr_pas;
		this.nbr_appui_gauche = nbr_appui_gauche;
		this.nbr_appui_droit = nbr_appui_droit;
		this.vitesse = vitesse;
		this.rythme = rythme;
		this.distance = distance;
		this.qualite_pression = qualite_pression;
		this.quantite_pression = quantite_pression;
		this.pression_arterielle = pression_arterielle;
		this.temps = temps;
		this.app_number = app_number;
		this.affected_exercice = affected_exercice;
		this.device_user = device_user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStability() {
		return stability;
	}
	public void setStability(int stability) {
		this.stability = stability;
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
	public void setQuantite_pression(int quantite_pression) {
		this.quantite_pression = quantite_pression;
	}
	public int getPression_arterielle() {
		return pression_arterielle;
	}
	public void setPression_arterielle(int pression_arterielle) {
		this.pression_arterielle = pression_arterielle;
	}
	public Date getTemps() {
		return temps;
	}
	public void setTemps(Date temps) {
		this.temps = temps;
	}
	public int getApp_number() {
		return app_number;
	}
	public void setApp_number(int app_number) {
		this.app_number = app_number;
	}
	public Affected_exercice getAffected_exercice() {
		return affected_exercice;
	}
	public void setAffected_exercice(Affected_exercice affected_exercice) {
		this.affected_exercice = affected_exercice;
	}
	public Device_user getDevice_user() {
		return device_user;
	}
	public void setDevice_user(Device_user device_user) {
		this.device_user = device_user;
	}
	
	
	
	
	
	
	
	

}
