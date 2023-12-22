package com.mj.repo;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mj.entity.CoronaVaccine;
public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine,Long> {
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COMPANY=?
	//public List<CoronaVaccine> findByCompany(String company);
	//public List<CoronaVaccine> findByCompanyEquals(String company);
	public List<CoronaVaccine> findByCompanyIs(String company);

	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE PRICE < ?
	public List<CoronaVaccine> findByPriceLessThan(Double price);

	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE PRICE BETWEEN ? AND ?
	public List<CoronaVaccine> findByPriceBetween(Double startPrice,Double endPrice);

	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE 'p%'
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE '____'
	public List<CoronaVaccine> findByNameLike(String initChars);

	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE 'p%'
	public List<CoronaVaccine> findByNameStartingWith(String startLetters);

	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE '%na'
	public List<CoronaVaccine> findByNameEndingWith(String endLetters);

	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE '%e%'
	public List<CoronaVaccine> findByNameContaining(String letter);

	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY IN('india','bangladesh')
	//public List<CoronaVaccine> findByCountryIn(String ... countries);
	public List<CoronaVaccine> findByCountryIn(List<String> countries);

	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY NOT IN('india','bangladesh')
	public List<CoronaVaccine> findByCountryNotIn(List<String> countries);
	
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE COUNTRY <> 'bangladesh'
	public List<CoronaVaccine> findByCountryIsNot(String country);
	public List<CoronaVaccine> findByCountryNot(String country);
	
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE PRICE > ? ORDER BY PRICE ASC
	public List<CoronaVaccine> findByPriceGreaterThanOrderByPriceAsc(Double startPrice);
	
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE REG_NO = ?
	public Optional<CoronaVaccine> findByRegNo(Long regNo);
	
	/*USING MULTIPLE PROPERTIES BASED CONDITIONS*/
	
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME = ? AND COUNTRY=?
	//public List<CoronaVaccine> findByNameAndCountry(String name,String country);
	public List<CoronaVaccine> findByNameEqualsAndCountryEquals(String name,String country);
	
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME LIKE 'm%' OR PRICE BETWEEN ? AND ?
	public List<CoronaVaccine> findByNameLikeOrPriceBetween(String initChars,Double startPrice,Double endPrice);
	
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME COUNTRY IN('India','USA') AND PRICE BETWEEN ? AND ?
	public List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries,Double startPrice,Double endPrice);
	
	//SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT FROM CORONA_VACCINE WHERE NAME (COUNTRY IN('India','USA') AND NAME IN('MJ','MANOJ')) OR PRICE >= ?
	public List<CoronaVaccine> findByCountryInAndNameInOrPriceGreaterThanEqual(Collection<String> countries,Collection<String> names,Double startPrice);

}
