package com.mj.service;

import java.util.List;

import com.mj.document.Actor;

public interface IActorAssociationMgmtService {
	public String registerActor( Actor actor);
	public String registerActorsGroup( List<Actor> actorsList);
	public List<Actor> getActorsByCategory(String category);
	public Actor getActorByActorId(Integer id);
	public String updateActorByActorId(Integer id,String newAddrs,Long newMobileNo);
	public String updateActorsRenumerationByCategoryAndAge(String category,Float age,Double renumeration);
	public String saveOrUpdateActorByRenumeration(Double start,Double end,String newAddrs,Long newMobileNo,Float newAge);
	public String removeDocByAge(Float age);
	public String removeDocsByAge(Float age);
}
