package meylis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meylis.dao.StaffDAO;
import meylis.model.StaffBean;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static String ADD = "/addStaff.jsp";
	    //private static String UPDATE = "/updateProduct.jsp";
	    //private static String LIST_ALL = "/listProduct.jsp";
	    private StaffDAO dao;
       
   
    public StaffController() {
        super();
        dao = new StaffDAO();
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffBean staff = new StaffBean();
		staff.setId(request.getParameter("id"));
		staff.setName(request.getParameter("name"));
		staff.setEmail(request.getParameter("email"));
		staff.setDepartment(request.getParameter("department"));
		staff.setAge(Integer.parseInt(request.getParameter("age")));
		staff.setPassword(request.getParameter("password"));
		staff.setAddress(request.getParameter("address"));

		String Id = request.getParameter("id");
		if(Id == null || Id.isEmpty()){
	        dao.add(staff);
	    }
	    /*else{
	         staff.setId(Id);
	         dao.updateStaff(staff);
	   }*/
	        response.sendRedirect("login.jsp");
	}

	}


