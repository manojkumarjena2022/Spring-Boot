package com.mj.service;

import java.util.Optional;

import com.mj.entity.MarriageSeeker;

public interface IMarriageSeekerMgmtService {
	public String registerMarrigeSeeker(MarriageSeeker seeker);
	public Optional<MarriageSeeker> searchMarriageSeekerById(Long id);
}
