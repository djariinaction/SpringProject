/**
 * 
 */
package com.spring.shop.Musik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Sourabh
 *
 */
@Entity
@Table(name = "master_codes")
public class ReferenceData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mc_generator")
	@SequenceGenerator(name = "mc_generator", sequenceName = "master_codes_seq", allocationSize = 1)
	private long id;
	
	private String value;
	
	private String type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
