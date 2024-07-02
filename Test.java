package com.model;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student e1=new Student("Kavi Nilavu","IT","Data Structure",100);
		Student e2=new Student("Krishna","CSE","Full Stack",100);
		
		Transaction tr=null;
     try(Session session= HBUtil.getSesFactory().openSession())
     {
    	 tr=(Transaction) session.beginTransaction();
    	 session.persist(e1);
    	 session.persist(e2);
    	   tr.commit();
     }
     catch(Exception x)
     {
    	 if(tr!=null)
    	 {  
    		 tr.rollback();
    	     x.printStackTrace(); 
           
    	 }
     }
       
	}

}