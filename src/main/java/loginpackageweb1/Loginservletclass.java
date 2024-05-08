package loginpackageweb1;

import jakarta.servlet.ServletException;

//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import loginpackagebean1.Loginbean;
import loginpackagedou1.Logindou;

import java.io.IOException;

/**
 * Servlet implementation class Loginservletclass
 */
public class Loginservletclass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Loginservletclass() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Loginbean beanobj=new Loginbean();
		beanobj.setUsername(username);
		beanobj.setPassword(password);
		Logindou douobj=new Logindou();
		if(douobj.validate(beanobj)) {
			response.sendRedirect("loginsuccess.jsp");
		}else {
			response.sendRedirect("Newlogin.jsp");
		}
		
	}
	}


