package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import model.EmployeeManager;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int empid = Integer.parseInt(request.getParameter("T1"));
		String name = request.getParameter("T2");
		double salary = Double.parseDouble(request.getParameter("T3"));
		
		try {
			Employee E = new Employee(empid, name, salary);
			EmployeeManager EM = new EmployeeManager();
			pw.print(EM.updateData(E));
		} 
		catch (Exception e) {
			pw.print(e.getMessage());
		}
		
		RequestDispatcher RD = request.getRequestDispatcher("update.jsp");
		RD.include(request, response);
		
	}

}
