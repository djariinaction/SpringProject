package io.javabrains.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.model.Topic;

@Service
public class TopicService {

	
	List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("1","Topic1"),
			new Topic("2","Topic2"),
			new Topic("3","Topic3")));	 
			
	
	public List<Topic> getAllTopics() {
		return topics;
	}


	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}


	public Topic getTopic(String id) {
	
		return getAllTopics().stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}


	public void addTopic(Topic topic) {
	 getAllTopics().add(topic);

	}


	public void updateTopic(Topic topic ,String id) {
		for( Topic t : getAllTopics()){
			if(id.equals(t.getId())){
				t.setId(topic.getId());
				t.setName(topic.getName());	
			}
		
		}
	}


	public void deleteTopic(String id) {
		getAllTopics().removeIf(t -> t.getId().equals(id));
	}
	


	
}
