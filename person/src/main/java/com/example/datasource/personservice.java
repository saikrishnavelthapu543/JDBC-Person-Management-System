package com.example.datasource;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class personservice {
	@Autowired
	private persondao pd;
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public void save(personpojo p)
	{
		System.out.println("im in business class---->");
		pd.save(p);
		System.out.println("im out business class---->");
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public void update(int pid,String pname)
	{
		System.out.println("im in business class----->");
		pd.update(pid,pname);;
		System.out.println("im out business class----->");
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public void delete(int pid)
	{
		System.out.println("im in business class----->");
		pd.delete(pid);;
		System.out.println("im out business class----->");
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public personpojo getbyid(int pid) throws SQLException
	{
		System.out.println("im in business class----->");
		return pd.getbyid(pid);
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public personpojo  getbyname(String pname) throws SQLException
	{
		System.out.println("im in business class----->");
		 return pd.getbyname(pname);
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
	public List<personpojo> getall()
	{
		System.out.println("im in business class----->");
		return pd.getall();
		
	}
//System.out.println("------------------------------------------------------------------------------------------------------------");
}
