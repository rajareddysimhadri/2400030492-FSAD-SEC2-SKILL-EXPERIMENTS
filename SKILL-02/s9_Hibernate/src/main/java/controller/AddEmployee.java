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


@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.include(request, response);
		
		int empid = Integer.parseInt(request.getParameter("T1"));
		String name = request.getParameter("T2");
		double salary = Double.parseDouble(request.getParameter("T3"));
		
		try {
			Employee E = new Employee(empid, name, salary);
			EmployeeManager EM = new EmployeeManager();
			String ack = EM.InsertEmployee(E);
			pw.print(ack);
			} 
		catch (Exception e) {
			pw.print(e.getMessage());
		}
	}

}
