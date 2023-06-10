package com.database.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.database.stock.controller.stockmodel;
import com.database.stock.model.Stockmodel;
import com.database.stock.repositay.stockRepo;

@Service
public class stockservice {
@Autowired
stockRepo srepo;

public Stockmodel savedetails(Stockmodel hi) {
	// TODO Auto-generated method stub
  return	 srepo.save(hi);

}

public void deletedetails(int hi) {
	// TODO Auto-generated method stub
	 srepo.deleteById(hi);
}
public Object getdetails(int hi) {
	// TODO Auto-generated method stub
	return srepo.findById(hi);
}

public Stockmodel updateInfo(Stockmodel hi) {
	// TODO Auto-generated method stub
	return srepo.saveAndFlush(hi);
}

public List<Stockmodel> sortdesc(String cname) {
	// TODO Auto-generated method stub
	return srepo.findAll(Sort.by(cname).ascending());
}

public List<Stockmodel> paginationData(int cno, int csize) {
	// TODO Auto-generated method stub
	Page<Stockmodel> p=srepo.findAll(PageRequest.of(cno,csize));
	return p.getContent();
}

public List<Stockmodel> paginationAndSorting(int cno, int csize, String cname) {
	// TODO Auto-generated method stub
	Page<Stockmodel> p=srepo.findAll(PageRequest.of(cno,csize,Sort.by(cname).descending()));
	return p.getContent();
}






}
