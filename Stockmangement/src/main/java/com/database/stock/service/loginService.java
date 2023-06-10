package com.database.stock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.database.stock.model.loginmodel;
import com.database.stock.repositay.loginRepository;
@Service
public class loginService {
@Autowired
private loginRepository lrepo;

	public String checkLogin(String uname, String pwd) {
		    loginmodel user = lrepo.findByuname(uname);
		    if (user == null) {
		      return "no user found";
		    }
		    else{
		    	if(user.getPwd().equals(pwd)) {	    		
		    		return"Login Succesfull"; 
		    	}
		    	else {
		    		return "Login Failed";
		    	}
		}
	}
		

	
	public List<loginmodel> getUser() {
		// TODO Auto-generated method stub
		return lrepo.findAll();
	}


	public Optional<loginmodel> getloginbyId(int id) {
		// TODO Auto-generated method stub
		return lrepo.findById(id);
	}


	public loginmodel addlogin(loginmodel id) {
		// TODO Auto-generated method stub
		return lrepo.save(id);
	}


	public loginmodel update(loginmodel id) {
		// TODO Auto-generated method stub
		return lrepo.saveAndFlush(id);
	}


	public void delete(int id) {
		// TODO Auto-generated method stub
		lrepo.deleteById(id);
	}


	public List<loginmodel> sortAsc(String name) {
		// TODO Auto-generated method stub
		return lrepo.findAll(Sort.by(name).ascending());
	}


	public List<loginmodel> sortDesc(String name) {
		// TODO Auto-generated method stub
		return lrepo.findAll(Sort.by(name).descending());
	}


	public List<loginmodel> paginationD(int pno, int psize) {
		// TODO Auto-generated method stub
		Page<loginmodel>p=lrepo.findAll(PageRequest.of(pno, psize));
		return p.getContent();
	}


	public List<loginmodel> paginationS(int pno, int psize, String name) {
		// TODO Auto-generated method stub
		Page<loginmodel>p=lrepo.findAll(PageRequest.of(pno, psize,Sort.by(name).ascending()));
		return p.getContent();
	}

	

}
