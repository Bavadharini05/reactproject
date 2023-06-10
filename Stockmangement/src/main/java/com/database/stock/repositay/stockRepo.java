package com.database.stock.repositay;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.database.stock.model.Stockmodel;

import jakarta.transaction.Transactional;

public interface stockRepo extends JpaRepository<Stockmodel, Integer> {
	@Query(value="select * from component where ccode= ?1", nativeQuery = true)

	public List<Stockmodel> getD(@Param("ccode") int ccode);

	@Modifying

	@Transactional

	@Query(value="delete from component where ccode=:ccode and cname =:cname",nativeQuery=true)

	Integer deleteById(@Param("ccode") int cno,@Param("cname") String cname);
	@Modifying

	@Transactional

	@Query(value="update component set ccode =:ccode where cname =:cname",nativeQuery=true)

	public void  update(@Param("ccode") int ccode,@Param("cname") String cname);
//jpql
	@Query("select s from Stockmodel s where s.ccode=?1")
	public Stockmodel querybyid(int ccode);
	
	
	
	@Modifying
	@Transactional
	@Query(value = "delete from Stockmodel s where s.cname=?1")
	public void delete(String cname);
	 
	@Query(value = "select s from Stockmodel s where s.ccode between ?1 and ?2")
	public List<Stockmodel>between(int one,int two);
  


	

		
}