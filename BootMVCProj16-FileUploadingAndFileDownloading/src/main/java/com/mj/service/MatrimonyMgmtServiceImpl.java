package com.mj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.MarriageSeekerInfo;
import com.mj.repository.IMarriageSeekerInfoRepo;
@Service
public class MatrimonyMgmtServiceImpl implements IMatrimonyMgmtService {
	@Autowired
	IMarriageSeekerInfoRepo repo;
	
	@Override
	public String registerProfile(MarriageSeekerInfo entity) {
		return "Marriage seeker profilr created with profile ID:"+repo.save(entity).getProfileId();
	}

	@Override
	public Iterable<MarriageSeekerInfo> getAllProfiles() {
		return repo.findAll();
	}

}
