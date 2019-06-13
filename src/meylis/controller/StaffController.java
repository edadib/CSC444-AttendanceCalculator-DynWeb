package meylis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import meylis.dao.StaffDAO;
import meylis.model.StaffBean;
import meylis.model.WorkingBean;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ADD = "/addStaff.jsp";
	private static String LIST = "/listStaff.jsp";
	private static String UPDATE = "/updateStaff.jsp";
	private static String LOGIN = "/login.jsp";
	private static String VIEW = "/viewStaff.jsp";
	private static String LOG = "/viewLog.jsp";
	private StaffDAO d;


	public StaffController() {
		super();
		d = new StaffDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("listAll")){
        	forward = LIST;
        	request.setAttribute("staff", d.getAllStaff());
        }
        else if (action.equalsIgnoreCase("delete")){
    	    String id = (request.getParameter("id"));
            d.deleteStaff(id);
            forward = LIST;
            request.setAttribute("staff", d.getAllStaff());    
	    }
        else if (action.equalsIgnoreCase("update")){
    	    forward = UPDATE;
    	    String id = request.getParameter("id");
            StaffBean staff = d.getStaffById(id);
            request.setAttribute("staff", staff);
        }
        else if (action.equalsIgnoreCase("view")) {
        	forward = VIEW;
        	String id = request.getParameter("id");
            StaffBean staff = d.getStaffById(id);
            request.setAttribute("staff", staff);
            
        }
        else if (action.equalsIgnoreCase("create")){
    	    String id = (request.getParameter("id"));
    	    System.out.println(id);
    	    WorkingBean work = new WorkingBean();
    	    work.setW_ID(Integer.parseInt(id));
            d.createWork(work);
            forward = LIST;
            request.setAttribute("staff", d.getAllStaff());    
	    }
	    else if(action.equalsIgnoreCase("log")) {
	    	forward = LOG;
	    	String id = (request.getParameter("id"));
	    	System.out.println(id);
	    	int wid = Integer.parseInt(id);
	    	System.out.println(wid);
            WorkingBean work = d.getWorkLogById(wid);
            request.setAttribute("work",work);
	    }
	
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffBean staff = new StaffBean();
		staff.setName(request.getParameter("name"));
		staff.setAge(Integer.parseInt(request.getParameter("age")));
		staff.setDepartment(request.getParameter("department"));
		staff.setEmail(request.getParameter("email"));
		staff.setAddress(request.getParameter("address"));		
		staff.setPassword(request.getParameter("password"));
		staff.setGrade(request.getParameter("grade"));

		String Id = request.getParameter("id");
		
		if(Id == null || Id.isEmpty()){
			d.add(staff);
			response.sendRedirect("listStaff.jsp");
		}
		else{
	         staff.setId(Id);
	         d.updateStaff(staff);
	         HttpSession session = request.getSession(true);
	         session.setAttribute("staff",staff);
	         if(staff.getGrade().equalsIgnoreCase("admin")) {
	        	 response.sendRedirect("adminProfile.jsp");
	         }
	         else if(staff.getGrade().equalsIgnoreCase("member")) {
	        	 response.sendRedirect("memberProfile.jsp");
	         }
	    }
	    
	 }

	}
