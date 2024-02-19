package com.mj.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mj.document.Medal;
import com.mj.document.MedalType;
import com.mj.document.Player;
import com.mj.document.Sport;
import com.mj.service.ISportMgmtService;
@Component
public class SpringDataMongoDBRuner implements CommandLineRunner {
	@Autowired
	ISportMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*//prepare objects
		Player player=new Player();
		player.setPid(Long.valueOf(new Random().nextInt(100000)));
		player.setPname("manoj Kumar jena");
		player.setPadd("balasore");
		//prepare child-1 object-1
		Sport sport1=new Sport();
		sport1.setIsOlympicSport(true);
		sport1.setIsTeamSport(false);
		sport1.setKitItems(new String[] {"Table","Chess"});
		sport1.setSid(new Random().nextInt(2000));
		sport1.setSname("Chessboard");
		//prepare child-1 object-2
		Sport sport2=new Sport();
		sport2.setIsOlympicSport(true);
		sport2.setIsTeamSport(true);
		sport2.setKitItems(new String[] {"Bat","Ball","Wickets"});
		sport2.setSid(new Random().nextInt(2000));
		sport2.setSname("Cricket");
		player.setSports(Set.of(sport1,sport2));
		//prepare child-2 object-1
		Medal medal1=new Medal();
		medal1.setMid(UUID.randomUUID().toString().replace("_", "").substring(0,10));
		medal1.setSportName("Cricket");
		medal1.setEventName("Event1");
		medal1.setPrizeMoney(40000.0);
		medal1.setType(MedalType.BRONZE);
		//prepare child-2 object-2
		Medal medal2=new Medal();
		medal2.setMid(UUID.randomUUID().toString().replace("_", "").substring(0,10));
		medal2.setSportName("Chess");
		medal2.setEventName("Event2");
		medal2.setPrizeMoney(80000.0);
		medal2.setType(MedalType.GOLD);
		player.setMedals(Map.of("Tokyo",medal1,"India",medal2));
		try {
			System.out.println(service.registerPlayer(player));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		service.fetchAllPlayers().forEach(player->{
			System.out.println(player);
			player.getSports().forEach(sport->{
				System.out.println(sport);
			});
			player.getMedals().forEach((name,medal)->{
				System.out.println(name+" "+medal);
			});
		});
	}

}
