/**
 * 
 */
package com.spring.shop.Musik.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Sourabh
 *
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "artistId")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_generator")
	@SequenceGenerator(name = "artist_generator", sequenceName = "artist_seq", allocationSize = 1)
	@Column(name = "artist_id")
	private long artistId;
	
	
	private String name;
			
	//@JsonBackReference
	@ManyToMany(mappedBy = "artists")
	private List<Song> songs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}
	
	
}
