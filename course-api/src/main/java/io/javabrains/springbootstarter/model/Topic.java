package io.javabrains.springbootstarter.model;

import javax.xml.ws.ServiceMode;


public class Topic {

	public Topic() {}
	String id;
	String name;
	public Topic(String id, String name) {
		super();
	this.name=name;
	this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
