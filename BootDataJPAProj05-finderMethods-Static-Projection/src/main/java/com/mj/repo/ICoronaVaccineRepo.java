package com.mj.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mj.entity.CoronaVaccine;
import com.mj.type.ResultView;
public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine,Long> {

	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(Double price);
}
