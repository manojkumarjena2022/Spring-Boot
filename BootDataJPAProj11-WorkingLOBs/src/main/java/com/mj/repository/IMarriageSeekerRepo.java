package com.mj.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.mj.entity.MarriageSeeker;

public interface IMarriageSeekerRepo extends PagingAndSortingRepository<MarriageSeeker, Long> {

}
