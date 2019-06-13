package meylis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import meylis.dao.StaffDAO;
import meylis.model.StaffBean;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ADMIN = "/adminProfile.jsp";
	private static String MEMBER = "/memberProfile.jsp";
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String forward="";
        String action = request.getParameter("action");

        	
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("password"));
        	try {
   		
    			StaffBean staff = new StaffBean();
    			staff.setId(request.getParameter("id"));
    			staff.setPassword(request.getParameter("password"));


    			staff = dao.login(staff);

    			if(staff.getValid()==true)
    			{
    				HttpSession session = request.getSession(true);
    				//session.setAttribute("currentSessionstaff", staff.getId());
    				System.out.println(staff.getId());
                    String id = staff.getId();
                    staff = dao.getStaffById(id);
                    session.setAttribute("staff", staff);
    				System.out.println(staff.getGrade());
    				if(staff.getGrade().equalsIgnoreCase("admin")) {
    					forward = ADMIN;
    				}
    				else if(staff.getGrade().equalsIgnoreCase("member")){
    					forward = MEMBER;
    				}
                    RequestDispatcher view = request.getRequestDispatcher(forward);
                    view.forward(request, response);
    			}
    			else
    			{
    				HttpSession session = request.getSession(false);
    				response.sendRedirect("error.jsp");
    			}
    			
    		}

    		catch (Throwable ex) {
    			System.out.println(ex);
    		}
 
	}

}
