/**
 * 
 */
package com.spring.shop.Musik.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.Musik.model.Artist;
import com.spring.shop.Musik.model.Song;
import com.spring.shop.Musik.service.SongService;

/**
 * @author Sourabh
 *
 */
@RestController
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private SongService service;
	
	@RequestMapping("/test")
	public String test() {
		return "Welcome Foxtrot";
	}
	
	@RequestMapping(value  = "/" , method = RequestMethod.GET)
	public List<Song> getAllSongs() {
		
		List<Song> songs = new ArrayList<>();
		songs = service.getAllSongs();
		return songs;
	}
	
	/*@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Song findSong(@PathVariable Long id) {
		return service.findSong(id);
	}*/
	
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public Song addSong(@RequestBody Song song) {
		boolean hasAccess = false;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Iterator<? extends GrantedAuthority> iterator = auth.getAuthorities().iterator();
		while(iterator.hasNext()) {
			if("ROLE_ADMIN".equalsIgnoreCase(iterator.next().getAuthority())) {
				hasAccess = true;
			}
		}
		if(!hasAccess) {
			return null;
		}
		return service.addSong(song);
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.DELETE)
	public void deleteAllSongs() {
		boolean hasAccess = false;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Iterator<? extends GrantedAuthority> iterator = auth.getAuthorities().iterator();
		while(iterator.hasNext()) {
			if("ROLE_ADMIN".equalsIgnoreCase(iterator.next().getAuthority())) {
				hasAccess = true;
			}
		}
		if(!hasAccess) {
			return;
		}
		service.deleteAll();
	}
	

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteSong(Long id) {	
		boolean hasAccess = false;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Iterator<? extends GrantedAuthority> iterator = auth.getAuthorities().iterator();
		while(iterator.hasNext()) {
			if("ROLE_ADMIN".equalsIgnoreCase(iterator.next().getAuthority())) {
				hasAccess = true;
			}
		}
		if(!hasAccess) {
			return;
		}
		service.deleteSong(id);
	}
	
	@RequestMapping(value = "{id}" ,method = RequestMethod.PUT)
	public Song updateSong(@RequestBody Song song, @PathVariable Long id) {
		boolean hasAccess = false;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Iterator<? extends GrantedAuthority> iterator = auth.getAuthorities().iterator();
		while(iterator.hasNext()) {
			if("ROLE_ADMIN".equalsIgnoreCase(iterator.next().getAuthority())) {
				hasAccess = true;
			}
		}
		if(!hasAccess) {
			return null;
		}
		song.setSongId(id);
		Song currentSong = service.findSong(id);
		if(currentSong  == null) {
			return null;
		}
		currentSong.setTitle(song.getTitle());
		currentSong.setAlbum(song.getAlbum());
		currentSong.setGenre(song.getGenre());
		currentSong.setLanguage(song.getLanguage());
		return service.updateSong(currentSong);
	}
	
	@RequestMapping(value = "{title}", method = RequestMethod.GET)
	public List<Song> findSong(@PathVariable String title) {
		return service.findByTitle(title);
	}
	
	@RequestMapping(value = "/newsong", method = RequestMethod.GET)
	public Song getSongObject() {
		Song song = new Song();
		song.setArtists(new ArrayList<Artist>());
		return song;
	}
}
