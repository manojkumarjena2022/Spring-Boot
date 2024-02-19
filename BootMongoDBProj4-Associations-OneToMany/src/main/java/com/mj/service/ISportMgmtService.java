package com.mj.service;

import java.util.List;

import com.mj.document.Player;

public interface ISportMgmtService {
	public String registerPlayer(Player player);
	public List<Player> fetchAllPlayers();
}
