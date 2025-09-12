package com.example.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class persondao {
	 @Autowired
	    private DataSource ds;
	 personpojo person = new personpojo();
//System.out.println("------------------------------------------------------------------------------------------------------------");
	    public void save(personpojo p) {
	        try {
	            System.out.println("I am in DAO CLASS-----");
	            Connection con = ds.getConnection();
	            String sql = "INSERT INTO test1.personpojo (pid, pname, page, pqual) VALUES (?, ?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, p.getPid());      
	            ps.setString(2, p.getPname()); 
	            ps.setInt(3, p.getPage());      
	            ps.setString(4, p.getPqual());  
	            int rowsaffected= ps.executeUpdate();
	            System.out.println("rowsaffected----->"+rowsaffected);
	            System.out.println("I am out of DAO CLASS-----");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
//System.out.println("------------------------------------------------------------------------------------------------------------");
	   public void update(int pid,String pname)
	   {
		   try {
	            System.out.println("I am in DAO CLASS-----");
	            Connection con = ds.getConnection();
	            String sql = "UPDATE test1.personpojo SET pname = ? WHERE pid = ?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, pname);
	            ps.setInt(2, pid);
	            int rowsaffected= ps.executeUpdate();
	            System.out.println("rowsaffected----->"+rowsaffected);
	            System.out.println("I am out of DAO CLASS-----");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		   
	   }
//System.out.println("------------------------------------------------------------------------------------------------------------");
	   public void delete(int pid)
	   {
		   try {
	            System.out.println("I am in DAO CLASS-----");
	            Connection con = ds.getConnection();
	            String sql = "delete from  test1.personpojo where pid=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, pid);
	        int rowsaffected= ps.executeUpdate();
	        System.out.println("rowsaffected----->"+rowsaffected);
	            System.out.println("I am out of DAO CLASS-----");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		   
	   }
//System.out.println("------------------------------------------------------------------------------------------------------------");
	   
	   public personpojo getbyid(int pid) throws SQLException
	   {
		   System.out.println("I am in DAO CLASS----->");
		   Connection con=ds.getConnection();
		   String sql="select * from test1.personpojo where pid=?";
		   PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, pid);
          ResultSet rs= ps.executeQuery();
          while(rs.next())
          {
              person.setPid(rs.getInt("pid"));
              person.setPname(rs.getString("pname"));
              person.setPage(rs.getInt("page"));
              person.setPqual(rs.getString("pqual"));
          }
          System.out.println("I am out of DAO CLASS----->");   
          return person;
	   }
//System.out.println("------------------------------------------------------------------------------------------------------------");
	   public personpojo getbyname(String pname) throws SQLException
	   {
		   System.out.println("I am in DAO CLASS----->");
		   Connection con=ds.getConnection();
		   String sql="select * from test1.personpojo where pname=?";
		   PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, pname);
          ResultSet rs= ps.executeQuery();
          while(rs.next())
          {
        	  person.setPid(rs.getInt("pid"));
              person.setPname(rs.getString("pname"));
              person.setPage(rs.getInt("page"));
              person.setPqual(rs.getString("pqual"));
          }
          System.out.println("I am out of DAO CLASS----->");   
          return person;
	   }
 //System.out.println("------------------------------------------------------------------------------------------------------------");   
	   public List<personpojo> getall()
	      {
		   List<personpojo> p=new ArrayList<>();
	    	  try {
		            System.out.println("I am in DAO CLASS-----");
		            Connection con = ds.getConnection();
		            String sql = "select * from test1.personpojo";
		            PreparedStatement ps = con.prepareStatement(sql);
		           ResultSet rs= ps.executeQuery();
		           while(rs.next())
		           {
		        	   personpojo person = new personpojo();
		               person.setPid(rs.getInt("pid"));
		               person.setPname(rs.getString("pname"));
		               person.setPage(rs.getInt("page"));
		               person.setPqual(rs.getString("pqual"));
		        	 p.add(person);
		        	 System.out.println(rs.getInt("pid")+" "+rs.getString("pname")+" "+rs.getInt("page")+" "+rs.getString("pqual"));
		           }
		            System.out.println("I am out of DAO CLASS----->");
		        } catch (SQLException e) {
		            e.printStackTrace();
	      }
	    	  return p;
	    }
//System.out.println("------------------------------------------------------------------------------------------------------------");

}
