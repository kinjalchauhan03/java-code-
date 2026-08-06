import java.sql.*;
public class ckjdbc001
{
	public static void main(String args[])
	{
		Statement s;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("ckk");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud","root","");
			System.out.println("ckk1");
			s=c.createStatement();
			System.out.println("ckk2");
			rs=s.executeQuery("select * from studinfo");
			System.out.println("ckk3");
			while(rs.next())
			{
				System.out.println(rs.getInt("sno")+"\t"+rs.getString("sname")+"\t"+rs.getString("sex"));
			}
			s.close();
			c.close();
		}
		catch(SQLException e)
		{
			System.out.println("sql error");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("class not found");
		}
	}
}