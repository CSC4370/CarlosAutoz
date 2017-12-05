package Projects;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Project3
 */
@WebServlet("/Project3")
public class Project3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/Project3Base","Daniel","password");
			
			Statement sqlState = conn.createStatement();
			Statement sqlState2 = conn.createStatement();
			Statement sqlState3 = conn.createStatement();
			Statement sqlState4 = conn.createStatement();
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			out.println("<table border = 1>");
			out.println("<tr>");
			out.println("<th>" + "New Car Make" + "</th>");
			out.println("<th>" + "New Car Year" + "</th>");
			out.println("<th>" + "New Car QTY" + "</th>");
			out.println("</tr>");
			
			String selectStuff = "Select * from newCarsTable";
			ResultSet rows = sqlState.executeQuery(selectStuff);
			while(rows.next()) {
				out.println("<tr>");
				out.println("<td>" + rows.getString("newCarsMake") + "</td>");
				out.println("<td>" + rows.getString("newCarsYear") + "</td>");
				out.println("<td>" + rows.getString("newCarsQTY") + "</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			
			out.println("<br />");
			
			out.println("<table border = 1>");
			out.println("<tr>");
			out.println("<th>" + "Used Car Make" + "</th>");
			out.println("<th>" + "Used Car Year" + "</th>");
			out.println("<th>" + "Used Car QTY" + "</th>");
			out.println("</tr>");
			
			String selectStuff2 = "Select * from usedCarsTable";
			ResultSet rows2 = sqlState2.executeQuery(selectStuff2);
			while(rows2.next()) {
				out.println("<tr>");
				out.println("<td>" + rows2.getString("usedCarsMake") + "</td>");
				out.println("<td>" + rows2.getString("usedCarsYear") + "</td>");
				out.println("<td>" + rows2.getString("usedCarsQTY") + "</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			
			out.println("<br />");
			
			out.println("<table border = 1>");
			out.println("<tr>");
			out.println("<th>" + "Username" + "</th>");
			out.println("<th>" + "Password" + "</th>");
			out.println("</tr>");
			
			String selectStuff3 = "Select * from registeredUsersTable";
			ResultSet rows3 = sqlState3.executeQuery(selectStuff3);
			while(rows3.next()) {
				out.println("<tr>");
				out.println("<td>" + rows3.getString("username") + "</td>");
				out.println("<td>" + rows3.getString("password") + "</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");

			out.println("<br />");
			
			out.println("<table border = 1>");
			out.println("<tr>");
			out.println("<th>" + "Added Car" + "</th>");
			out.println("<th>" + "Added QTY" + "</th>");
			out.println("</tr>");
			
			String selectStuff4 = "Select * from activeCartTable";
			ResultSet rows4 = sqlState4.executeQuery(selectStuff4);
			while(rows4.next()) {
				out.println("<tr>");
				out.println("<td>" + rows4.getString("addedCar") + "</td>");
				out.println("<td>" + rows4.getString("addedCarQTY") + "</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			
			rows.close();
			rows2.close();
			rows3.close();
			rows4.close();
			sqlState.close();
			sqlState2.close();
			sqlState3.close();
			sqlState4.close();
			conn.close();
		}
		
		
		catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
