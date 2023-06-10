package com.database.stock.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.stock.model.loginmodel;
import com.database.stock.service.loginService;

@RestController
@RequestMapping("/com")
public class loginController {
	@Autowired
	private loginService lser;
	@PostMapping("/login")
	public String login(@RequestBody Map<String, String> loginData) {
	    String uname = loginData.get("uname");
	    String pwd = loginData.get("pwd");
	    String result = lser.checkLogin(uname, pwd);
	    return result;
	  }
	   @GetMapping("/get")
   
   public List<loginmodel>listAll()
   {
	   return lser.getUser();
	   
   }
     @GetMapping("/get1/{id}")
     public Optional<loginmodel>  readbyid(@PathVariable("id")int id)
     {
    return lser.getloginbyId(id);
     }
     @PostMapping("/add/{id}")
     public loginmodel create(@RequestBody loginmodel id)
     {
    return lser.addlogin(id);
     }
     
     
     @PutMapping("/update")
     public loginmodel update(@RequestBody loginmodel id)
     {
    return lser.update(id);
     }
          @DeleteMapping("/delete/{id}")
     public String delete(@PathVariable("id")int id)
     {
    lser.delete(id);
    return "Deletion was successful";
     }
     
     @GetMapping("/sortasc/{name}")
     //sorting the given details 
     public List<loginmodel> sortAsc(@PathVariable("name")String name)
     {
    return lser.sortAsc(name);
     }
     
     @GetMapping("/sortdesc/{name}")
     //sorting the given details descending
     public List<loginmodel> sortdesc(@PathVariable("name")String name)
     {
    return lser.sortDesc(name);
     }
     
     //pagination in the given details
     @GetMapping("/pagination/{pno}/{psize}")
     public List<loginmodel> pagination(@PathVariable("pno")int pno,@PathVariable("psize")int psize)
     {
    return lser.paginationD(pno,psize);
     }
     
     //pagination and sorting
     @GetMapping("/pageandsort/{pno}/{psize}/{name}")
     public List<loginmodel> pagesort(@PathVariable("pno")int pno,@PathVariable("psize")int psize,@PathVariable("name")String name)
     {
    return lser.paginationS(pno,psize,name);
     }
     
     
     
         
     
}
