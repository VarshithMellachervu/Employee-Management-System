import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class EmployeeLogin extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String empname=req.getParameter("empname");
		String empid=req.getParameter("empid");
		String pass=req.getParameter("password");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			Statement st=con.createStatement();
            String query="SELECT *FROM employee WHERE EmployeeName='"+empname+"' and Employeeid='"+empid+"' and Password='"+pass+"';";
            ResultSet rs=st.executeQuery(query);
			if (rs.next()) 
            {
                String employeename = rs.getString("EmployeeName");
                String employeeid = rs.getString("Employeeid");
                String password = rs.getString("Password");
                String email= rs.getString("Email");
                String mobile= rs.getString("Mobile");
                String gender= rs.getString("Gender");
                String Des= rs.getString("Designation");
                String Dept= rs.getString("Department");
                String Doj= rs.getString("DateofJoin");
                String Empcity= rs.getString("EmployeeCity");
                String Empsal= rs.getString("EmployeeSalary");
                req.setAttribute("name",employeename);
                req.setAttribute("id",employeeid);
                req.setAttribute("pass",password);
                req.setAttribute("email",email);
                req.setAttribute("mobile",mobile);
                req.setAttribute("gender",gender);
                req.setAttribute("Des",Des);
                req.setAttribute("Dept",Dept);
                req.setAttribute("Doj",Doj);
                req.setAttribute("Empcity",Empcity);
                req.setAttribute("Empsal",Empsal);
                RequestDispatcher rd = req.getRequestDispatcher("/Employeehome.jsp");
                rd.forward(req, res);
            }

			else
			{
				out.println("<br><h1 style='text-align:center;color:red;'>Login Failed <br> Please check your Details or contact Administrator</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("/Employeelogin.html");
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