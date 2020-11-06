package org.epodia.metier;

import java.util.List;

import org.epodia.entities.Media;

public interface MediaMetier {
	
	public Media saveMedia(Media M);
	
	public List<Media> listMedia();
	
	public Media updateMedia(Media M , Long id);
	
	public Media getMediaById(Long id);
	
	public void deleteMedia(Long id);
}
