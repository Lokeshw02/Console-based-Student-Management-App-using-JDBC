import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;


public class start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome To Student Management App");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		
		while(true) {
			System.out.println("Press 1 to add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Exit App");
			
			int c = Integer.parseInt(br.readLine()) ;
			
			if(c==1) {
				//Add Stuent 
				System.out.println("Enter User Name : ");
				String name = br.readLine();
				System.out.println("Enter User's Phone No. : ");
				String phone  = br.readLine() ;
				System.out.println("Enter User City  : ");
				String city = br.readLine() ;
				
				Student st = new Student(name,phone,city) ;
				
				boolean answer = StudentDao.insertToDB(st); 
				
				if(answer) {
					System.out.println("Student is Added Successfully"); 
					
				}
				
				else {
					
					System.out.println("Something went wrong ....Try again ");
				}
				
				
				System.out.println(st); 
				
				
				
			}
			else if(c==2) {
				//Delete Student 
				System.out.println("Enter the Student ID to Delete : ");
				int userId = Integer.parseInt(br.readLine()) ;
				boolean f = StudentDao.deleteStudent(userId) ; 
				
				if(f) {
					System.out.println("The student deleted successfully "); 
					
				}
				
				else {
					System.out.println("Some issue....could not perform the Delete Operation ");
				}
				
				
				
				
			}
			else if(c==3) {
				//Dislpay Student 
				
				StudentDao.showAllstudents() ;
				
			}
			else if (c==4) {
				//break ;
				break ;
				
			}
			
			
		}
		
		System.out.println("Thanks for using my App"); 
		System.out.println("See you next time");

	}

}
