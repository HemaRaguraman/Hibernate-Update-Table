package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Test1 {

	public static void main(String[] args) {
		
		Transaction tr=null;
	     try(Session session=HBUtil.getSesFactory().openSession())
	     {
	          tr= session.beginTransaction();
	          List<Student> li=session.createQuery("from Student",Student.class).list();
	          System.out.println("NAME      \t    DEPT        \t SUB       \t MARK");
	          li.forEach(e->{
	            System.out.println(e.getName()+"\t"+e.getDept()+"\t"+e.getSub()+"\t"+e.getMarks());
	          });//for(Student s:li)
	          tr.commit();
	     }
	          catch(Exception x)
	          {
	         	 if(tr!=null)
	         	 {   tr.rollback();
	         	     x.printStackTrace(); 
	                
	         	 }
	          }
	     }
	}