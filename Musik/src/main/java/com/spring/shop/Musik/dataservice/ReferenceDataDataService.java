/**
 * 
 */
package com.spring.shop.Musik.dataservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.shop.Musik.model.ReferenceData;

/**
 * @author Sourabh
 *
 */
@Repository
public interface ReferenceDataDataService extends CrudRepository<ReferenceData, Long>{
	List<ReferenceData> findByType(String type);
}
