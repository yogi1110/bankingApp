
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Transaction extends HttpServlet {
	String driver="oracle.jdbc.driver.OracleDriver";
	String path="jdbc:oracle:thin:@//localhost:1521/XE";
	String user="system";
	String pass="system";
	Connection con=null;
	PreparedStatement ps1=null;
	PreparedStatement ps2=null;
	String sql1="UPDATE Bank SET  balance =balance-?  WHERE  accno=?";
	String sql2="UPDATE  Bank  SET balance =balance+? WHERE  accno=? ";
	
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
	
	public void service(HttpServletRequest req, HttpServletResponse res){
		try
		{
			String toacc= req.getParameter("toacc");
			String pwd= req.getParameter("pwd");
	        String amt= req.getParameter("amt");
			HttpSession hs=req.getSession();
			String acc=(String) hs.getAttribute("ACCNO");
			int bal=(Integer) hs.getAttribute("BALENCE");
			con.setAutoCommit(false);
			ps1=con.prepareStatement(sql1);
			ps1.setString(1,amt );
			ps1.setString(2,acc);
			ps2=con.prepareStatement(sql2);
			ps2.setString(1,amt );
			ps2.setString(2,toacc);
			
		    int up1=ps1.executeUpdate();
		    int up2=ps2.executeUpdate();
		   pw=res.getWriter();
		   if(up1!=0&&up2!=0){
			   con.commit();
			   res.sendRedirect("/Bankingapp/transactionsuccess.html");
		   }
	}
catch (Exception e) {
e.printStackTrace();
}
	}
	
	public void destroy(){
		try{
			con.close();
			ps1.close();			
			ps2.close();
			pw.close();
		}
		catch (Exception e) {
	e.printStackTrace();	}
	}
	
}
