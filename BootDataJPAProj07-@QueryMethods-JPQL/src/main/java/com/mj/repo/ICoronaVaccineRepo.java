package com.mj.repo;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mj.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine,Long> {
	//==============SELECT ROW PERFORMING BULK ROW OR MULTIPLE ROW OPERATION=================
	//Entity query for multiple row selecting all columns
	//@Query("FROM com.mj.entity.CoronaVaccine WHERE company=?1")
	//@Query("FROM CoronaVaccine WHERE company=?1")
	//@Query("FROM CoronaVaccine as cv WHERE cv.company=?1")
	//@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=?1")
	//@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=?") //Legacy-style query parameters (`?`) are no longer supported; use JPA-style ordinal parameters (e.g., `?1`) instead
	/*@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=:vendor")
	public List<CoronaVaccine>searchVaccineByCompany(String vendor);*/
	@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=:comp")
	public List<CoronaVaccine> searchVaccineByCompany(@Param("comp")String vendor);
	//@Query("FROM CoronaVaccine WHERE price>=?1 AND price<=?2")
	@Query("FROM CoronaVaccine WHERE price>=:min AND price<=:max")
	public List<CoronaVaccine> searchVaccineByPriceRange(Double min,Double max);
	//scalar projection query selecting multiple columns
	@Query("SELECT name,company,price FROM CoronaVaccine WHERE company IN(:company1,:company2,:company3)")
	public List<Object[]> searchVaccineDataByCompanies(String company1,String company2,String company3);
	//scalar projection query selecting single columns
	@Query("SELECT price FROM CoronaVaccine WHERE name IN(:name1,:name2)")
	public List<Double> searchVaccinePriceByNames(String name1,String name2);

	//==============SELECT ROW PERFORMING SINGLE ROW OPERATION=================
	//Entity query for single row selecting all columns
	@Query("FROM CoronaVaccine WHERE name=:name")
	public Optional<CoronaVaccine> searchVaccineByName(String name);
	//scalar projection query selecting multiple columns
	@Query("SELECT name,company,price FROM CoronaVaccine WHERE name=:name")
	public Object searchVaccineDataByName(String name);
	//scalar projection query selecting single columns
	@Query("SELECT country FROM CoronaVaccine WHERE name=:name")
	public String searchVaccineCountryByName(String name);
	
	//==============AGGREGATE FUNCTION=================
	@Query("SELECT COUNT(*) FROM CoronaVaccine")
	public Long fetchVaccinesCount();
	@Query("SELECT COUNT(*),MAX(price),MIN(price),SUM(price),AVG(price) FROM CoronaVaccine WHERE price BETWEEN :min AND :max")
	public Object fetchVaccinesAggregateDataByPriceRange(Double min,Double max);
	
	//================ NON-SELECT OPERATION ======================
	@Modifying
	@Query("UPDATE CoronaVaccine SET price=:newPrice WHERE country=:country")
	public int updatePriceByCountry(Double newPrice,String country);
	
	@Modifying
	@Query("DELETE FROM CoronaVaccine WHERE price between :startPrice AND :endPrice")
	public int deleteVaccineByPriceRange(Double startPrice,Double endPrice);
	
	//====================== NATIVE-SQL QUERIES ===========================
	@Modifying
	@Transactional
	@Query(value="INSERT INTO CORONA_VACCINE VALUES(VACCINE_REG_NO_SEQ.NEXTVAL,?,?,?,?,?)",nativeQuery = true)
	public int insertVaccine(String company,String country,String name,Double price,Integer doseCount);
	
	@Query(value = "SELECT SYSDATE FROM DUAL",nativeQuery = true)
	public Date getSystemDate();
	
	@Query(value = "CREATE TABLE TEMP(col1 number(10),col2 varchar2(15))",nativeQuery = true)
	@Modifying
	@Transactional
	public int createTempTable();
}
