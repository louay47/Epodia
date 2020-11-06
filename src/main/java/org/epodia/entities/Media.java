package org.epodia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.epodia.enumeration.Media_type;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Media implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
		private long id ;
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "MEDIA" , nullable = false)
		private Media_type media_type ;
		private String media_url ;
		public Media() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Media(Media_type media_type, String media_url) {
			super();
			this.media_type = media_type;
			this.media_url = media_url;
		}
		public long getMedia_id() {
			return id;
		}
		public void setMedia_id(long id) {
			this.id = id;
		}
		public Media_type getMedia_type() {
			return media_type;
		}
		public void setMedia_type(Media_type media_type) {
			this.media_type = media_type;
		}
		public String getMedia_url() {
			return media_url;
		}
		public void setMedia_url(String media_url) {
			this.media_url = media_url;
		}
		
		
	

}
