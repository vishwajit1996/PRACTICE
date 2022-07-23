package com.dailycoding.dao;
import com.dailycoding.beans.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmpDao {

	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","test1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
	public static List<Emp> getRecords(int start,int total){
		List<Emp> list=new ArrayList<Emp>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from emp limit "+(start-1)+","+total);
			//0 , 5
			//5 to 5
			//10 ,5
			//
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				list.add(e);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static int insertEmployeeData(Emp emp) {
		int rowsEffected = 0;
		
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into emp ");
			ps.setInt(1, emp.getId());
			ps.setString(1, emp.getName());
			ps.setFloat(2, emp.getSalary());
			 rowsEffected=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsEffected;
		
		
		
	}
}
