package com.mj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mj.document.Player;

public interface IPlayerRepo extends MongoRepository<Player, Long> {

}
