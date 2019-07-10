/**
 * 
 */
package com.spring.shop.Musik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.Musik.dataservice.ArtitstDataService;
import com.spring.shop.Musik.model.Artist;

/**
 * @author Sourabh
 *
 */
@Service
public class ArtitstService {
	
	@Autowired
	private ArtitstDataService dataService;
	
	public List<Artist> getArtistByName(String name) {
		return dataService.findByName(name);
	}
}
