

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Updatepass extends HttpServlet 
{
	String driver="oracle.jdbc.driver.OracleDriver";
	String path="jdbc:oracle:thin:@//localhost:1521/XE";
	String user="system";
	String pass="system";
	Connection con=null;
	PreparedStatement ps=null;
	String sql="UPDATE  Bank  SET password=?  WHERE password=?";
	PrintWriter pw=null;
	public void init()
	{
		try
		{
			Class.forName(driver);
		con=	DriverManager.getConnection(path, user, pass);
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
				String oldpas= req.getParameter("oldpas");
				String newpas= req.getParameter("newpas");
				String confpas= req.getParameter("confpas");
				ps=con.prepareStatement(sql);
				ps.setString(1,confpas );
				ps.setString(2,oldpas);
				pw=res.getWriter();
				if(newpas.contentEquals(confpas))
				{
			    int up=ps.executeUpdate();
			    if(up!=0){
					   res.sendRedirect("/Bankingapp/successfull.html");
				   }
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
