package org.epodia.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.epodia.enumeration.Category;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Proxy(lazy=false)
public class Generated_exercice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
		private long id ;
		private String exercice_name ;
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "CATEG_TYPE" , nullable = false)
		private Category category ; 
		private String description ;
		
		private Media media ;
	@OneToMany(mappedBy="generated_exercice",fetch=FetchType.LAZY)
		private Collection<Affected_exercice> affected_exercice ;
	@ManyToOne
	@JoinColumn(name="EXPERT")
		private Expert experts ;
	public Generated_exercice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Generated_exercice(String exercice_name, Category category, String description, Media media,
			Collection<Affected_exercice> affected_exercice, Expert experts) {
		super();
		this.exercice_name = exercice_name;
		this.category = category;
		this.description = description;
		this.media = media;
		this.affected_exercice = affected_exercice;
		this.experts = experts;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExercice_name() {
		return exercice_name;
	}
	public void setExercice_name(String exercice_name) {
		this.exercice_name = exercice_name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	@JsonIgnore
	public Collection<Affected_exercice> getAffected_exercice() {
		return affected_exercice;
	}
	@JsonSetter
	public void setAffected_exercice(Collection<Affected_exercice> affected_exercice) {
		this.affected_exercice = affected_exercice;
	}
	public Expert getExperts() {
		return experts;
	}
	public void setExperts(Expert experts) {
		this.experts = experts;
	}
	
	
	

}
