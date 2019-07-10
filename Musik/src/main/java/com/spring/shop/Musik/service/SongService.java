/**
 * 
 */
package com.spring.shop.Musik.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.spring.shop.Musik.dataservice.SongDataService;
import com.spring.shop.Musik.model.Artist;
import com.spring.shop.Musik.model.Song;

/**
 * @author Sourabh
 *
 */

@Service
public class SongService  {
	
	@Autowired
	private SongDataService songDataService;
	
	@Autowired
	private ArtitstService artitstService;
	
	public List<Song> getAllSongs() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<Song> songs = new ArrayList<>();
		songs.addAll((Collection<? extends Song>) songDataService.findAll());
		return songs;
	}
	
	public Song addSong(Song song) {
		if(song.getArtists() != null && !song.getArtists().isEmpty()) {
			for (Artist artist : song.getArtists()) {
				List<Artist> artistFromDB = artitstService.getArtistByName(artist.getName());
				if(artistFromDB != null && !artistFromDB.isEmpty()) {
					artist.setArtistId(artistFromDB.get(0).getArtistId());
				}
			}
		}
		return songDataService.save(song);
	}
	
	public void deleteAll() {
		songDataService.deleteAll();
	}

	public Song findSong(Long id) {
		return songDataService.findById(id).get();
	}

	public void deleteSong(Long id) {
		songDataService.deleteById(id);
	}

	public Song updateSong(Song song) {
		if(song.getArtists() != null && !song.getArtists().isEmpty()) {
			for (Artist artist : song.getArtists()) {
				List<Artist> artistFromDB = artitstService.getArtistByName(artist.getName());
				if(artistFromDB != null && !artistFromDB.isEmpty()) {
					artist.setArtistId(artistFromDB.get(0).getArtistId());
				}
			}
		}
		return songDataService.save(song);
	}
	
	public List<Song> findByTitle(String title) {
		return songDataService.findByTitle(title);
	}
}
