package org.epodia.services;

import java.util.List;

import org.epodia.entities.Media;
import org.epodia.metier.MediaMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MediaService {
	
	@Autowired
	private MediaMetier mediaMetier ;

	@RequestMapping(value="/Media",method=RequestMethod.POST)
	public Media saveMedia(@RequestBody Media M) {
		return mediaMetier.saveMedia(M);
	}

	@RequestMapping(value="/Media",method=RequestMethod.GET)
	public List<Media> listMedia() {
		return mediaMetier.listMedia();
	}

	@RequestMapping(value="/Media/{id}",method=RequestMethod.PUT)
	public Media updateMedia(@RequestBody Media M, @PathVariable("id") Long id) {
		return mediaMetier.updateMedia(M, id);
	}

	@RequestMapping(value="/Media/{id}",method=RequestMethod.GET)
	public Media getMediaById(@PathVariable("id") Long id) {
		return mediaMetier.getMediaById(id);
	}

	@RequestMapping(value="/Media/{id}",method=RequestMethod.DELETE)
	public void deleteMedia(@PathVariable("id") Long id) {
		mediaMetier.deleteMedia(id);
	}

}
