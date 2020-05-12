

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Updateprofile extends HttpServlet
{
	String driver="oracle.jdbc.driver.OracleDriver";
	String path="jdbc:oracle:thin:@//localhost:1521/XE";
	String user="system";
	String pass="system";
	Connection con=null;
	PreparedStatement ps=null;
	String sql="UPDATE  Bank  SET name=?  WHERE password=?";
	PrintWriter pw=null;
	public void init()
	{
		try
		{
			Class.forName(driver);
		con= DriverManager.getConnection(path, user, pass);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	//init over
	public void service(HttpServletRequest req, HttpServletResponse res){
		try
		{
			String oldname= req.getParameter("oldname");
			String upass= req.getParameter("passwor");
			String newname= req.getParameter("newname");
			ps=con.prepareStatement(sql);
			ps.setString(1,newname );
			ps.setString(2,upass);
		    int up=ps.executeUpdate();
		   pw=res.getWriter();
		   if(up!=0){
			   res.sendRedirect("/Bankingapp/successfull.html");
		   }
	}
catch (Exception e) {
e.printStackTrace();
}
	}
	
	public void destroy(){
		try{
			con.close();
			ps.close();
			pw.close();
		}
		catch (Exception e) {
	e.printStackTrace();	}
	}
}