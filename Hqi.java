package com.model;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;

import jakarta.persistence.Query;


public class Hqi {
		public static void main(String args[]) {
			Transaction tr= null;
			try(Session session = HBUtil.getSesFactory().openSession()){
				tr = session.beginTransaction();
			     List li = session.createQuery("select * from Student where marks>95",Student.class).list();    
			for(Object a:li)
			{
				System.out.print(a);
			}
		}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
}
 
}

