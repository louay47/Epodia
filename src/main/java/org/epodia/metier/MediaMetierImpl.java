package org.epodia.metier;

import java.util.List;

import org.epodia.dao.MediaRepository;
import org.epodia.entities.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaMetierImpl implements MediaMetier {

	@Autowired
	private MediaRepository mediaRepository ;
	
	@Override
	public Media saveMedia(Media M) {
		// TODO Auto-generated method stub
		return mediaRepository.save(M);
	}

	@Override
	public List<Media> listMedia() {
		// TODO Auto-generated method stub
		return mediaRepository.findAll();
	}

	@Override
	public Media updateMedia(Media M, Long id) {
		// TODO Auto-generated method stub
		return mediaRepository.saveAndFlush(M);
	}

	@Override
	public Media getMediaById(Long id) {
		// TODO Auto-generated method stub
		return mediaRepository.getOne(id);
	}

	@Override
	public void deleteMedia(Long id) {
		// TODO Auto-generated method stub
		
	}

}
