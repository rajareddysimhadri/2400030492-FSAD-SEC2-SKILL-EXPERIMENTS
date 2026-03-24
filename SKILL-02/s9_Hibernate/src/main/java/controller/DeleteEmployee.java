package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EmployeeManager;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int empid = Integer.parseInt(request.getParameter("T1"));
		
		
		try {
			
			EmployeeManager EM = new EmployeeManager();
			String ack = EM.deleteData(empid);
			pw.print(ack);
		} 
		catch (Exception e) {
			pw.print(e.getMessage());
		}
		
		RequestDispatcher RD = request.getRequestDispatcher("delete.jsp");
		RD.include(request, response);
	}

}
