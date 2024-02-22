package com.mj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mj.document.Actor;
import com.mongodb.client.result.UpdateResult;

@Service("actorService")
public class ActorAssociationMgmtServiceImpl implements IActorAssociationMgmtService {
	@Autowired
	MongoTemplate template;

	@Override
	public String registerActor(Actor actor) {
		Actor actor1=template.save(actor);//creates the collection with Document class name 'Actor'
		//Actor actor1=template.save(actor,"Artist");//creates the collection with given name 'Artist'
		//Actor actor1=template.insert(actor);//creates the collection with Document class name 'Actor'
		return "Document is saved with id value :"+actor.getActorId();
	}

	@Override
	public String registerActorsGroup(List<Actor> actorsList) {
		return actorsList.size()+" no of records are inserted."+template.insertAll(actorsList);
	}

	@Override
	public List<Actor> getActorsByCategory(String category) {
		Query query=new Query();
		query.addCriteria(Criteria.where("category").is(category));
		List<Actor> actors=template.find(query, Actor.class);
		return actors;
	}

	@Override
	public Actor getActorByActorId(Integer id) {
		Actor actor=template.findById(id, Actor.class);
		return actor;
	}

	@Override
	public String updateActorByActorId(Integer id, String newAddrs, Long newMobileNo) {
		// prepare query object for retrieving doc
		Query query=new Query();
		query.addCriteria(Criteria.where("actorId").is(id));
		//prepare update object for modifying the doc
		Update update=new Update();
		update.set("actorAddrs", newAddrs);
		update.set("mobileNo", newMobileNo);
		//find doc and modify the doc
		Actor actor=template.findAndModify(query, update, Actor.class);
		return actor==null?"Actor not found for modificstion":"Actor found and modified";
	}

	@Override
	public String updateActorsRenumerationByCategoryAndAge(String category, Float age, Double renumeration) {
		// prepare query object for retrieving doc
		Query query=new Query();
		query.addCriteria(Criteria.where("category").is(category).andOperator(Criteria.where("age").gte(age)));
		//prepare update object
		Update update=new Update().set("renumaeration", renumeration);
		//invoke update multi method
		UpdateResult result=template.updateMulti(query, update, Actor.class);
		return result.getModifiedCount()+" Actors are modified.";
	}
	@Override
	public String saveOrUpdateActorByRenumeration(Double start, Double end, String newAddrs, Long newMobileNo,
			Float newAge) {
		Query query=new Query();
		query.addCriteria(Criteria.where("renumeration").gte(start).andOperator(Criteria.where("renumeration").lte(end)));
		//prepare update object
		Update update=new Update().set("actorAddrs", newAddrs).set("mobileNo", newMobileNo).set("age", newAge);
		UpdateResult result=template.upsert(query, update, Actor.class);
		return result.getModifiedCount()+" updated and inserted doc id is :"+result.getUpsertedId();
	}
	@Override
	public String removeDocByAge(Float age) {
		Query query=new Query();
		query.addCriteria(Criteria.where("age").gt(age));
		Actor actor=template.findAndRemove(query, Actor.class);
		return actor.getActorId()+" is removed";
	}
	@Override
	public String removeDocsByAge(Float age) {
		Query query=new Query();
		query.addCriteria(Criteria.where("age").gt(age));
		List<Actor> list=template.findAllAndRemove(query, Actor.class);
		return list.size()+" docs are removed";
	}
}
