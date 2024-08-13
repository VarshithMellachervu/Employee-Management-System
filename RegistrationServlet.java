import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RegistrationServlet extends HttpServlet
{
		public void doPost(HttpServletRequest req,HttpServletResponse res)
		{
			res.setContentType("text/html");
			String btn=req.getParameter("submit");
			try
			{
					res.setContentType("text/html");
					PrintWriter out=res.getWriter();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					if(btn.equals("Register"))
					{
							String empname=req.getParameter("empname");
							String empid=req.getParameter("empid");
							String emppass=req.getParameter("emppass");
							String empemail=req.getParameter("empemail");
			 				String empmobile=req.getParameter("empmobile");
							String gender=req.getParameter("gender");
							String empdes=req.getParameter("empdes");
							String empdepart=req.getParameter("empdepart");
							String empdoj=req.getParameter("empdoj");
							String empcity=req.getParameter("empcity");
							String empsalary=req.getParameter("empsalary");
							String query="Insert into employee values(?,?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement ps=con.prepareStatement(query);
							ps.setString(1,empname);
							ps.setString(2,empid);
							ps.setString(3,emppass);
							ps.setString(4,empemail);
			 				ps.setString(5,empmobile);
							ps.setString(6,gender);
							ps.setString(7,empdes);
							ps.setString(8,empdepart);
							ps.setString(9,empdoj);
							ps.setString(10,empcity);
							ps.setString(11,empsalary);
							int x=ps.executeUpdate();
							if(x==1)
							{
								String query1="SELECT *FROM employee;";
								ResultSet rs=ps.executeQuery(query1);
								if(rs.next())
								{
									RequestDispatcher rd=req.getRequestDispatcher("/Registered.html");
									rd.forward(req,res);
								}	
							}
							else
							{
								out.println("<h1 align='center'><font color='red'>Employee record is not inserted</font></h1>");
								RequestDispatcher rd=req.getRequestDispatcher("/Emp_Insert.html");
								rd.forward(req,res);
							}	
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception:" +e);
				}
		}
}	
					