package com.mj.service;

import com.mj.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public Iterable<CoronaVaccine> fetchDetails(boolean asc,String... props);
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo,int pageSize,boolean asc,String... props);
	public void fetchDetailsByPagination(int pageSize);
}
