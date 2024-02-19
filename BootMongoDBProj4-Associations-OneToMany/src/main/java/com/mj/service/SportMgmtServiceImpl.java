package com.mj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.document.Player;
import com.mj.repository.IPlayerRepo;
@Service("playerService")
public class SportMgmtServiceImpl implements ISportMgmtService {
	@Autowired
	IPlayerRepo playerRepo;
	@Override
	public String registerPlayer(Player player) {
		return "Player registered with id:"+playerRepo.save(player).getPid();
	}

	@Override
	public List<Player> fetchAllPlayers() {
		return playerRepo.findAll();
	}

}
