/**
 * 
 */
package com.spring.shop.Musik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.Musik.dataservice.ReferenceDataDataService;
import com.spring.shop.Musik.model.ReferenceData;

/**
 * @author Sourabh
 *
 */
@Service
public class ReferenceDataService {
	
	@Autowired
	private ReferenceDataDataService dataService;
	
	public List<ReferenceData> getDataByType(String type) {
		return dataService.findByType(type);
	}
}
