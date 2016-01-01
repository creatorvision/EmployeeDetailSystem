import java.util.*;
import java.io.*;
import java.sql.*;

class EmployeeDetail
{
	String employeeid;
	String name;
	int age;
	String designation;
	double salary;

	Scanner in = new Scanner(System.in);

	void addEmployee()
	{
		System.out.println("Enter the Employee Id of the employee");
		employeeid = in.nextLine();	
		addEmployee(employeeid);
	}
	void addEmployee(String employeeid)
	{

		System.out.println("Enter the name of the employee");
		name = in.nextLine();
		System.out.println("Enter the age of the employee");
		age = in.nextInt();
		in.nextLine();
		System.out.println("Enter the designation of the employee");
		designation = in.nextLine();
		System.out.println("Enter the salary of the employee");
		salary = in.nextInt();
		in.nextLine();
		final String user;
   		final String pass;
   		Connection conn = null;
   		Statement stmt = null;

		try
		{
	
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Enter you Mysql Username :");
			user = in.nextLine();
			System.out.println("Enter you Mysql Password :");
			pass = in.nextLine();
			System.out.println("Connecting to database...");
     		conn = DriverManager.getConnection("jdbc:mysql://localhost/employee",user,pass);

     		stmt = conn.createStatement();
      		String sql = "CREATE TABLE IF NOT EXISTS employeedetail"+ "(EMPLOYEE_ID VARCHAR(255) ,NAME VARCHAR(255), AGE INT(100), DESIGNATION VARCHAR(255), SALARY INT(100) )";
     		stmt.executeUpdate(sql);
     		stmt.close();

     		stmt = conn.createStatement();
      		sql = "INSERT INTO employeedetail VALUE ('"+employeeid+"','"+name+"','"+ age +"','"+ designation +"','"+ salary+"')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
           
            stmt.close();
      		conn.close();

     	}
     	catch(SQLException se)
     	{
      		se.printStackTrace();
   		}
   		catch(Exception e)
   		{
      		e.printStackTrace();
      	}
      	finally
      	{
      		try
      		{
      			conn.close();
      		}
      		catch(SQLException se1)
      		{
      			se1.printStackTrace();
      		}
      	}
	}
	void viewEmployee()
	{
		System.out.println("Enter the Employee ID of the employee");
		employeeid = in.nextLine();
		viewEmployee(employeeid);

	}

	void viewEmployee( String employeeid )
	{

		final String user;
   		final String pass;
   		Connection conn = null;
   		Statement stmt = null;

		try
		{
	
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Enter you Mysql Username :");
			user = in.nextLine();
			System.out.println("Enter you Mysql Password :");
			pass = in.nextLine();
			System.out.println("Connecting to database...");
     		conn = DriverManager.getConnection("jdbc:mysql://localhost/employee",user,pass);

     		/*// CHECK FOR TABLE EXISTENCE
     		DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null,"%", null);
			while (rs.next()) {
			  System.out.println(rs.getString(3));
			  if(rs.getString(3) == null)
			  {
			  	System.out.println("Table Doesn't Exist");
			  	return;
			  }
			}*/

			stmt = conn.createStatement();
      		String sql = "CREATE TABLE IF NOT EXISTS employeedetail"+ "(EMPLOYEE_ID VARCHAR(255) ,NAME VARCHAR(255), AGE INT(100), DESIGNATION VARCHAR(255), SALARY INT(100) )";
     		stmt.executeUpdate(sql);
     		stmt.close();

     		stmt = conn.createStatement();
      		sql = "SELECT * from employeedetail where EMPLOYEE_ID = '"+ employeeid +"' ";
      		ResultSet rs = stmt.executeQuery(sql);

      		int count=0;
      		while(rs.next())
      		{
      			count++;
      			String name = rs.getString("NAME");
      			int age = rs.getInt("AGE");
      			String designation = rs.getString("DESIGNATION");
      			int salary = rs.getInt("SALARY");

      			System.out.println("EMPLOYEE_ID :"+ employeeid);
      			System.out.println("NAME :" + name);
      			System.out.println("AGE :" + age);
      			System.out.println("Designation: " + designation);
      			System.out.println("Salary:" + salary);
      		}
      		System.out.println("The No. of Entries for the entered Employee id: "+ employeeid+ "are -> "+ count);

      		rs.close();
            stmt.close();
      		conn.close();

     	}
     	catch(SQLException se)
     	{
      		se.printStackTrace();
   		}
   		catch(Exception e)
   		{
      		e.printStackTrace();
      	}
      	finally
      	{
      		try
      		{
      			conn.close();
      		}
      		catch(SQLException se1)
      		{
      			se1.printStackTrace();
      		}
      	}
	}
	void deleteEmployee()
	{
		System.out.println("Enter the Employee ID of the employee");
		employeeid = in.nextLine();
		deleteEmployee(employeeid);
	}

	void deleteEmployee(String employeeid)
	{
		final String user;
   		final String pass;
   		Connection conn = null;
   		Statement stmt = null;

		try
		{
	
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Enter you Mysql Username :");
			user = in.nextLine();
			System.out.println("Enter you Mysql Password :");
			pass = in.nextLine();
			System.out.println("Connecting to database...");
     		conn = DriverManager.getConnection("jdbc:mysql://localhost/employee",user,pass);

     		System.out.println(" Below is the entry you are requesting to delete permanently from Database");
     		viewEmployee(employeeid); // View your request before executing it. (before deleting it).

	   		stmt = conn.createStatement();
      		String sql = "DELETE from employeedetail where EMPLOYEE_ID = '"+ employeeid +"' ";
      		stmt.executeUpdate(sql);

            stmt.close();
      		conn.close();

     	}
     	catch(SQLException se)
     	{
      		se.printStackTrace();
   		}
   		catch(Exception e)
   		{
      		e.printStackTrace();
      	}
      	finally
      	{
      		try
      		{
      			conn.close();
      		}
      		catch(SQLException se1)
      		{
      			se1.printStackTrace();
      		}
      	}

	}
	void viewEntireEmployee()
	{
		final String user;
   		final String pass;
   		Connection conn = null;
   		Statement stmt = null;

		try
		{
	
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Enter you Mysql Username :");
			user = in.nextLine();
			System.out.println("Enter you Mysql Password :");
			pass = in.nextLine();
			System.out.println("Connecting to database...");
     		conn = DriverManager.getConnection("jdbc:mysql://localhost/employee",user,pass);

     		/*// CHECK FOR TABLE EXISTENCE
     		DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, null,"%", null);
			while (rs.next()) {
			  System.out.println(rs.getString(3));
			  if(rs.getString(3) == null)
			  {
			  	System.out.println("Table Doesn't Exist");
			  	return;
			  }
			}*/

			stmt = conn.createStatement();
      		String sql = "CREATE TABLE IF NOT EXISTS employeedetail"+ "(EMPLOYEE_ID VARCHAR(255) ,NAME VARCHAR(255), AGE INT(100), DESIGNATION VARCHAR(255), SALARY INT(100) )";
     		stmt.executeUpdate(sql);
     		stmt.close();

     		stmt = conn.createStatement();
      		sql = "SELECT * from employeedetail ";
      		ResultSet rs = stmt.executeQuery(sql);

      		int count=0;
      		while(rs.next())
      		{
      			count++;
      			String employeeid = rs.getString("EMPLOYEE_ID");
      			String name = rs.getString("NAME");
      			int age = rs.getInt("AGE");
      			String designation = rs.getString("DESIGNATION");
      			int salary = rs.getInt("SALARY");

      			System.out.println("EMPLOYEE_ID :"+ employeeid);
      			System.out.println("NAME :" + name);
      			System.out.println("AGE :" + age);
      			System.out.println("Designation: " + designation);
      			System.out.println("Salary:" + salary);
      		}
      		System.out.println("Total No. of employees in the firm : "+ count);


      		rs.close();
            stmt.close();
      		conn.close();

     	}
     	catch(SQLException se)
     	{
      		se.printStackTrace();
   		}
   		catch(Exception e)
   		{
      		e.printStackTrace();
      	}
      	finally
      	{
      		try
      		{
      			conn.close();
      		}
      		catch(SQLException se1)
      		{
      			se1.printStackTrace();
      		}
      	}
	}
	void updateEmployee()
	{
		System.out.println("Enter the Employee Id of the employee");
		employeeid = in.nextLine();	
		deleteEmployee(employeeid);
		addEmployee(employeeid);

	}
} 

public class Employee 
{
	public static void main(String[] args) {
		
		char choice;
		while(true)
		{
			System.out.println(" MENU ");
			System.out.println(" a.Add new Employee in Database ");
			System.out.println(" b.View an existing Employee's Detail ");
			System.out.println(" c.Delete an existing Employee ");
			System.out.println(" d.View Entire List of Employees ");
			System.out.println(" e.Update/ Re-Enter an entery ");
			System.out.println(" f.Exit ");

			Scanner in = new Scanner(System.in);
			choice = in.nextLine().charAt(0);

			switch(choice)
			{
				case 'a': 
				{
					System.out.println("-------------------------------------------------------------------------------------");
					EmployeeDetail emp = new EmployeeDetail(); // new Employee object
					emp.addEmployee();
					System.out.println("-------------------------------------------------------------------------------------");
					break;
				}
				case 'b':
				{
					System.out.println("--------------------------------------------------------------------------------------");					
					EmployeeDetail emp = new EmployeeDetail(); // new Employee object
					emp.viewEmployee();
					System.out.println("--------------------------------------------------------------------------------------");
					break;
				}
				case 'c':
				{
					System.out.println("---------------------------------------------------------------------------------------");
					EmployeeDetail emp = new EmployeeDetail(); // new Employee object
					emp.deleteEmployee();
					System.out.println("---------------------------------------------------------------------------------------");
					break;
				}
				case 'd':
				{
					System.out.println("-------------------------------------------------------------------------------------");
					EmployeeDetail emp = new EmployeeDetail(); // new Employee object
					emp.viewEntireEmployee();
					System.out.println("-------------------------------------------------------------------------------------");
					break;
				}
				case 'e' :
				{
					System.out.println("-------------------------------------------------------------------------------------");
					EmployeeDetail emp = new EmployeeDetail(); // new Employee object
					emp.updateEmployee();
					System.out.println("-------------------------------------------------------------------------------------");					
					break;
				}
				case 'f':
				{
					System.exit(0);
				}
				default : System.exit(0); // Existing the system
			}
		}	
	}
}
