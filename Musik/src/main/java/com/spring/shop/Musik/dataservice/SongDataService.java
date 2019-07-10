/**
 * 
 */
package com.spring.shop.Musik.dataservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.shop.Musik.model.Song;

/**
 * @author Sourabh]
 *
 */
@Repository
public interface SongDataService extends CrudRepository<Song, Long> {
	
	//@Query("SELECT t FROM Song t where t.title = :title") 
    List<Song> findByTitle(String title);
}
