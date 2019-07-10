/**
 * 
 */
package com.spring.shop.Musik.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Sourabh
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "songId")
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song_generator")
	@SequenceGenerator(name = "song_generator" , sequenceName = "song_seq", allocationSize = 1)
	@Column(name = "song_id")
	private long songId;
	
	private String title;
	
	private String genre;
	
	//@JsonManagedReference
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
	        name = "Song_Artist", 
	        joinColumns = { @JoinColumn(name = "song_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "artist_id") }
	    )
	private List<Artist> artists;
	
	private String language;
	
	private String album;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public long getSongId() {
		return songId;
	}

	public void setSongId(long songId) {
		this.songId = songId;
	}
	
	
	
}
