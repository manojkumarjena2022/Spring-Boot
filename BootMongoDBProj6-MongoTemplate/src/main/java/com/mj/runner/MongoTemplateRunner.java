package com.mj.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.document.Actor;
import com.mj.service.IActorAssociationMgmtService;
@Component
public class MongoTemplateRunner implements CommandLineRunner {
	@Autowired
	IActorAssociationMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(service.registerActor(new Actor(new Random().nextInt(1000), "Manoj", "Bollywood", 29.5f, 8764545456L)));
		//System.out.println(service.registerActor(new Actor(757, "Manoj", "Bollywood", 29.5f, 8764545456L)));

		/*System.out.println(service.registerActorsGroup(List.of(
				new Actor(new Random().nextInt(1000),"MJ", "Tollywood", 27f, 87645457876L),
				new Actor(new Random().nextInt(1000),"Kumar", "JollyWood", 28.5f, 8986654656L),
				new Actor(new Random().nextInt(1000),"MJ Kumar", "Bollywood", 25f, 879876456L)
				)));*/
		//service.getActorsByCategory("Bollywood").forEach(System.out::println);
		
		//System.out.println(service.getActorByActorId(612));
		
		//System.out.println(service.updateActorByActorId(612, "bbsr", 9876543123L));
		
		//System.out.println(service.updateActorsRenumerationByCategoryAndAge("Bollywood", 24f, 9000.0));
		
		//System.out.println(service.saveOrUpdateActorByRenumeration(1000.0, 10000.0, "SNG", 9876453454L, 40f));
		
		//System.out.println(service.removeDocByAge(29f));
		
		System.out.println(service.removeDocsByAge(25f));
	}

}
