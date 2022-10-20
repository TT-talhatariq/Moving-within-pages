

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			DataBase dbBase = new DataBase();
			boolean status = dbBase.login(userName, password) ;
			
			if(status) {
				// if login is successful
				RequestDispatcher rd = request.getRequestDispatcher("main");
				rd.forward(request, response);
				
				//response.sendRedirect("main");
			}
			else {
				// if login is not successful
				response.sendRedirect("error");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
}
