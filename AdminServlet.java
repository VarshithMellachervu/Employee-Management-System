import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AdminServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String uname=req.getParameter("n1");
		String pass=req.getParameter("p1");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			Statement st=con.createStatement();
			String query="SELECT *FROM admin_login WHERE AdminName='"+uname+"' and Password='"+pass+"';";
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
			
				out.println("<h1 align='center'><font color='green'>Welcome "+rs.getString(1)+"</font></h1>");
				RequestDispatcher rd=req.getRequestDispatcher("/Admin_home.html");
				rd.include(req,res);
			}
			else
			{
				out.println("<h1 align='center'>Entered username or password is wrong</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("/adminlogin.html");
				rd.include(req,res);

			}
			rs.close();
 			st.close();
 			con.close();
 		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}