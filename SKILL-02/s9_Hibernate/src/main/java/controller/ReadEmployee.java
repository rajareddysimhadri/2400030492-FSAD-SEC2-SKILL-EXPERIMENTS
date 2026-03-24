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


@WebServlet("/ReadEmployee")
public class ReadEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReadEmployee() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			EmployeeManager EM = new EmployeeManager();
			request.setAttribute("list", EM.getData());
			
		} 
		catch (Exception e) {
			pw.print(e.getMessage());
		}
		
		RequestDispatcher RD = request.getRequestDispatcher("read.jsp");
		RD.forward(request, response);
		
	}

}
