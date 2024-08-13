import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EmployeeDelete extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String employeeid=req.getParameter("Empid");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			Statement st=con.createStatement();
            String query="Delete from employee where Employeeid='"+employeeid+"';";
			int x=st.executeUpdate(query);
			if(x==1)
			{
				out.println("<h1 align='center'><font color='purple'>Record Deleted Succesfully</font></h1>");
				RequestDispatcher rd=req.getRequestDispatcher("/Admin_home.html");
				rd.include(req,res);  
			} 
			else
			{
				out.println("<h1 align='center'><font color='red'>Record is not Deleted</font></h1>");
				RequestDispatcher rd=req.getRequestDispatcher("/Emp_Delete.html");
				rd.include(req,res);
			}
		}
		catch(Exception e)
		{
			out.println("Exception:" +e);
		}
	}
}		