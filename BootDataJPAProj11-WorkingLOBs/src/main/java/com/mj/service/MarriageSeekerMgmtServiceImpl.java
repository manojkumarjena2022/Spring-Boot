package com.mj.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.entity.MarriageSeeker;
import com.mj.repository.IMarriageSeekerRepo;
@Service("mrgSeekerService")
public class MarriageSeekerMgmtServiceImpl implements IMarriageSeekerMgmtService {
@Autowired
IMarriageSeekerRepo repo;
	@Override
	public String registerMarrigeSeeker(MarriageSeeker seeker) {
		MarriageSeeker seekerData=repo.save(seeker);
		return "User registered with Id ::"+seekerData.getId();
	}
	@Override
	public Optional<MarriageSeeker> searchMarriageSeekerById(Long id) {
		return repo.findById(id);
	}

}
