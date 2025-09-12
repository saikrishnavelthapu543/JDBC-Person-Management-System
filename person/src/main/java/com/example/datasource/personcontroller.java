package com.example.datasource;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("datasource")
public class personcontroller {
	@Autowired
	private personservice ps;
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@PostMapping("save")
	public personpojo save(@RequestBody personpojo p)
	{
		System.out.println("im in controller class------>");
		ps.save(p);
		System.out.println("im out controller class----->");
		return p;
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@PutMapping("update/{pid}/{pname}")
	public String update(@PathVariable int pid,@PathVariable String pname)
	{
		System.out.println("im in controller class----->");
		ps.update(pid,pname);;
		return "updated";
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@DeleteMapping("delete/{pid}")
	public String delete(@PathVariable int pid)
	{
		System.out.println("im in controller class----->");
		ps.delete(pid);;
		return "deleted";
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@GetMapping("getbyid/{pid}")
	public personpojo getbyid(@PathVariable int pid) throws SQLException
	{
		System.out.println("im in controller class----->");
		return ps.getbyid(pid);
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@GetMapping("getbyname/{pname}")
	public personpojo  getbyname(@PathVariable String pname) throws SQLException
	{
		System.out.println("im in controller class----->");
		return ps.getbyname(pname);
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	@GetMapping("getall")
	public List<personpojo> getall()
	{
		System.out.println("im in controller class----->");
		return ps.getall();
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");

	
	

}
