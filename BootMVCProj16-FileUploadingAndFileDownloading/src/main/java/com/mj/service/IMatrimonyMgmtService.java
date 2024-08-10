package com.mj.service;

import com.mj.entity.MarriageSeekerInfo;

public interface IMatrimonyMgmtService {
	public String registerProfile(MarriageSeekerInfo entity);
	public Iterable<MarriageSeekerInfo> getAllProfiles();
}
