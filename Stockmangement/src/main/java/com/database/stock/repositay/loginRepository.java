package com.database.stock.repositay;

import org.springframework.data.jpa.repository.JpaRepository;

import com.database.stock.model.loginmodel;

public interface loginRepository extends JpaRepository<loginmodel, Integer> {
	loginmodel findByuname(String uname);
	


}
