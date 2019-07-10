/**
 * 
 */
package com.spring.shop.Musik.dataservice;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.shop.Musik.model.Artist;

/**
 * @author Sourabh
 *
 */
@Repository
public interface ArtitstDataService extends  CrudRepository<Artist, String>{
	
	List<Artist> findByName(String name);


}
