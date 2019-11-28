package tasks;

import java.sql.*;  
class Updatedb
{  
	static void updatedb1(String name,String phone,String mail,String hname,String hphone,String hmail)throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/innovaccer","/*Database User*/","/*Database Password*/"); //database user and password
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("Select * from Visitor where Phone='"+phone+"'");
		int size=0;
		while(rs.next())
		{
			size++;
			if(size==1)
				break;
		}
		if(size==0)
		{
			stmt.executeUpdate("Insert into Visitor values ('"+name+"' , '"+phone+"' , '"+mail+"')");
		}
		rs=stmt.executeQuery("Select * from Host where Phone='"+hphone+"'");
		size=0;
		while(rs.next())
		{
			size++;
			if(size==1)
				break;
		}
		if(size==0)
		{
			stmt.executeUpdate("Insert into Host values ('"+hname+"' , '"+hphone+"' , '"+hmail+"')");
		}
		stmt.executeUpdate("Insert into Visit values ('"+phone+"' , '"+hphone+"' , '"+(java.time.LocalTime.now())+"' , 'null')");
		con.close();
	}
	static void updatedb2(String phone)throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/innovaccer","/*Database User*/","/*Database Password*/");//database user and password 
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("Select * from Visit where Vphone='"+phone+"'");
		String hphone="",Intime="",Outtime,name,hname,mail,hmail;
		while(rs.next())
		{
			if(rs.getString(4).contentEquals("null"))
			{
				hphone=rs.getString(2);
				Intime=rs.getString(3);
			}
		}
		stmt.executeUpdate("Update Visit Set Outtime='"+(java.time.LocalTime.now())+"' where Vphone='"+phone+"' and Hphone='"+hphone+"' and Intime='"+Intime+"'");
		rs=stmt.executeQuery("Select Outtime from Visit where Vphone='"+phone+"' and Hphone='"+hphone+"' and Intime='"+Intime+"'");
		rs.next();
		Outtime=rs.getString(1);
		rs=stmt.executeQuery("Select * from  Visitor where Phone='"+phone+"'");
		rs.next();
		name=rs.getString(1);
		mail=rs.getString(3);
		rs=stmt.executeQuery("Select * from Host where Phone='"+hphone+"'");
		rs.next();
		hname=rs.getString(1);
		hmail=rs.getString(2);
		Sendmail.sendemail2(mail,name,phone,Intime,Outtime,hname);
		con.close();
	}
	public static void main(String args[])
	{  
		
	}  
}  