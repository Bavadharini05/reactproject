package com.database.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.stock.model.Stockmodel;
import com.database.stock.repositay.stockRepo;
import com.database.stock.service.stockservice;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class stockcontroller {
	@Autowired
	public stockservice sser;
	@Tag(name = "Posting",description = "Posting the given details")
	@PostMapping("/Components")
	public Stockmodel savedetails(@RequestBody Stockmodel hi) 
	
	{
		return sser.savedetails(hi);
	}
	@Tag(name = "Deleting",description = "Deleting the given details")
	@DeleteMapping("/deleteid/{hi}")
	public String deletedetails(@PathVariable("hi")int hi)
	{
		sser.deletedetails(hi);
		return "deleted";
		
	}
	@Tag(name = "Get Details",description = "To get the required detail")
	@GetMapping("/getid/{hi}")
	public Object getdetails(@PathVariable("hi")int hi)
	{
		return sser.getdetails(hi);
	}
	@Tag(name = "Updating",description = "Update the given details")
	@PutMapping("/updatestock")
	
	public Stockmodel updatedetails(@RequestBody Stockmodel hi)
	{
		return sser.updateInfo(hi);
	}
	//sorting 
	@Tag(name = "Get Details",description = "To get the required detail")
	@GetMapping("/sortdes/{cname}")
	public List<Stockmodel>sortComponent(@PathVariable("cname")String cname)
	{
		return sser.sortdesc(cname);
	}
	//pagination
	@Tag(name = "Get Details",description = "To get the required detail")
	@GetMapping("/pagination/{cno}/{csizo}")
	public List<Stockmodel>paginationData1(@PathVariable("cno")int cno,@PathVariable("csizo")int csize)
	{
		return sser.paginationData(cno,csize);
	}
	//pagination and sorting
	@Tag(name = "Get Details",description = "To get the required detail")
	@GetMapping("/paginationSorting/{cno}/{csize}/{cname}")
	public List<Stockmodel>paginationSorting(@PathVariable("cno")int cno,@PathVariable("csize")int csize,@PathVariable("cname")String cname)
	{
		return sser.paginationAndSorting(cno,csize,cname);
	}
@Autowired
	
	public stockRepo srepo;
@Tag(name = "Get Details",description = "To get the required detail")

	@GetMapping("/query")

	public List<Stockmodel> getAll()
	{
		return srepo.findAll();
	}
@Tag(name = "Deleting",description = "Deleting the given details")
	@DeleteMapping("/deletequery/{ccode}/{cname}")
	public String deleteDetails(@PathVariable int ccode,@PathVariable String cname)
	{	
		srepo.deleteById(ccode,cname);
		return "Deleted Successfully";
	}
	@Tag(name = "Updating",description = "Update the given details")
	@PutMapping("/queryupdate/{ccode}/{cname}")
	public String updateDetails(@PathVariable int ccode,@PathVariable String cname)
	{
		 srepo.update(ccode,cname); 
		 return "updated";
	}
	//jpql
	@Tag(name = "Get Details",description = "To get the required detail")
	@GetMapping("/queryget/{ccode}")
	public Stockmodel querybyid(@PathVariable ("ccode")int ccode)
	{
		return srepo.querybyid(ccode);
	}
	@Tag(name = "Deleting",description = "Deleting the given details")
		@DeleteMapping("/jpqldelete/{cname}")
	public String jpqldelete(@PathVariable("cname")String cname)
	{
		srepo.delete(cname);
		return "deleted";
	}
		@Tag(name = "Get Details",description = "To get the required detail")
	@GetMapping("/jpqlget/{one}/{two}")
	public List<Stockmodel>between(@PathVariable("one")int one,@PathVariable("two")int two)
	{
		return srepo.between(one, two);
	}
}

