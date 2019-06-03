package meylis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meylis.dao.StaffDAO;
import meylis.model.StaffBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StaffDAO dao;
    HttpServletRequest request;
    HttpServletResponse response;
    String forward="";
    String action="";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//action = request.getParameter("action");
        	
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("password"));
        	try {
   		
    			StaffBean staff = new StaffBean();
    			staff.setId(request.getParameter("id"));
    			staff.setPassword(request.getParameter("password"));

    			staff = StaffDAO.login(staff);

    			if(staff.getValid()==true)
    			{
    				HttpSession session = request.getSession(true);
    				session.setAttribute("currentSessionstaff", staff.getId());
    				response.sendRedirect("listStaff.jsp"); // logged-in page
    			}
    			else
    			{
    				response.sendRedirect("login.jsp");
    			}
    			
    		}

    		catch (Throwable ex) {
    			System.out.println(ex);
    		}
 
	}

}
