/**
 * 
 */
package com.spring.shop.Musik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.shop.Musik.model.ReferenceData;
import com.spring.shop.Musik.service.ReferenceDataService;

/**
 * @author Sourabh
 *
 */
@RestController
@RequestMapping("/data")
public class ReferenceDataController {
		
	@Autowired
	private ReferenceDataService service;
	
	@RequestMapping(value = "{type}", method = RequestMethod.GET)
	public List<ReferenceData> getDataByType(@PathVariable String type) {
		return service.getDataByType(type);
	}
}
