package io.javabrains.springbootstarter.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.model.Topic;
import io.javabrains.springbootstarter.service.TopicService;

@RestController

public class TopicController {
	@Autowired
	private TopicService topicService ;
	
	@RequestMapping(method=RequestMethod.GET,value="/topics")
	public List<Topic> getTopics(){
		return  topicService.getAllTopics();
}

	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return  topicService.getTopic(id); 
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopics(@RequestBody Topic topic) {
		  topicService.addTopic(topic); 
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void addTopics(@PathVariable String id, @RequestBody Topic topic) {
		  topicService.updateTopic(topic,id); 
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void addTopics(@PathVariable String id) {
		  topicService.deleteTopic(id); 
		
	}
	

}
