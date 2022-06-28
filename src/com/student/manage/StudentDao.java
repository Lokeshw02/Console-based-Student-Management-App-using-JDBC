package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class StudentDao {
	
	public static  boolean insertToDB(Student st ) {
		
		
		boolean f = false ;
		
		
		//jdbc Code
		
		try {
			
			Connection con = CP.createC() ;
			String q = "insert into students(sname,sphone,scity) values(?,?,?)" ;
			//Prepared Statement 
			
			PreparedStatement pstmt =  con.prepareStatement(q) ;		
			//Set the values of Parameteres 
			pstmt.setString(1,st.getStudentName()) ;
			pstmt.setString(2,st.getStudentPhone()) ;
			pstmt.setString(3,st.getStudentCity()) ;
			
			
			//Execute 
			pstmt.executeUpdate() ;
			f = true ;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
		
		
		
		return f ; 
		
	}

	public static boolean deleteStudent(int userId) {
boolean f = false ;
		
		
		//jdbc Code
		
		try {
			
			Connection con = CP.createC() ;
			String q = "delete from students where sid = ?" ;
			//Prepared Statement 
			
			PreparedStatement pstmt =  con.prepareStatement(q) ;		
			//Set the values of Parameteres 
			pstmt.setInt(1, userId);
			
//			pstmt.setString(2,st.getStudentPhone()) ;
//			pstmt.setString(3,st.getStudentCity()) ;
			
			
			//Execute 
			pstmt.executeUpdate() ;
			f = true ;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
		
		
		
		return f ; 
		
		
		
	}

	public static void showAllstudents() {
		
           
		
		
		//jdbc Code
		
		try {
			
			
			Connection con = CP.createC() ;
			String q = "select * from students;" ;
			//Prepared Statement 
			
//			PreparedStatement pstmt =  con.prepareStatement(q) ;		
//			//Set the values of Parameteres 
//			pstmt.setInt(1, userId);
			
//			pstmt.setString(2,st.getStudentPhone()) ;
//			pstmt.setString(3,st.getStudentCity()) ;
			
			
			java.sql.Statement stmt = con.createStatement();
			
			ResultSet set = ((java.sql.Statement) stmt).executeQuery(q) ;
			
			
			while(set.next()) {
				
				int id = set.getInt(1) ;
				String name = set.getString(2) ;
				String phone = set.getString(3) ;
				String city = set.getString("scity") ;
				
				
				
				System.out.println("ID :" + id); 
				System.out.println("NAME :" + name); 
				System.out.println("PHONE :" + phone); 
				System.out.println("CITY : :" + city); 
				System.out.println("---------------------------------------------------"); 
				
				
			}
			
			
			
		
			
			
			//Execute 
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
		
		
		
		
		
	}

}
