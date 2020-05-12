

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Homeservlet extends HttpServlet {
	String driver="oracle.jdbc.driver.OracleDriver";
	String path="jdbc:oracle:thin:@//localhost:1521/XE";
	String user="system";
	String pass="system";
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sql="select * from bank where  accno=? AND password=?";
	PrintWriter pw=null;
	public void init()
	{
		try{
			Class.forName(driver);
		con=	DriverManager.getConnection(path, user, pass);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//init over
	public void service(HttpServletRequest req, HttpServletResponse res){
		try
		{
			String uacc= req.getParameter("acc");
			String upass= req.getParameter("pass");
			ps=con.prepareStatement(sql);
			ps.setString(1,uacc );
			ps.setString(2,upass );
			rs=ps.executeQuery();
			pw=res.getWriter();
			if(rs.next()==true)
			{
				String ac=rs.getString(1);
				String n=rs.getString(2);
				String at=rs.getString(3);
				int bal=rs.getInt(4);
				String  pa=rs.getString(5);
				int ph=rs.getInt(6);
				HttpSession hs=req.getSession(true);
				hs.setAttribute("ACCNO", ac);
				hs.setAttribute("NAME", n);
				hs.setAttribute("ACCTYPE", at);	
				hs.setAttribute("BALENCE", bal);
				hs.setAttribute("PASSWORD", pa);
				hs.setAttribute("PHNO", ph);
				//pw.println(ac+"   "+n+"   "+at+"   "+bal+"   "+pa+"   "+ph);
				res.sendRedirect("/Bankingapp/Success.jsp");
				
			}
			else{
				res.sendRedirect("/Bankingapp/invalid.html");
			}
			
		}
		catch (Exception e) 
		{
e.printStackTrace();		
        }
	}
	
public void destroy(){
	try{
		con.close();
		ps.close();
		rs.close();
		pw.close();
	}
	catch (Exception e) {
e.printStackTrace();	}
}
}
