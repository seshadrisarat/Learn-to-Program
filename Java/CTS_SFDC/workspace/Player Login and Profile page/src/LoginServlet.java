import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlayerBO pbo = new PlayerBO();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username != null & password != null) {
			Player p = null;
			try {
				p = pbo.validateLogin(username, password);
			} catch (ClassNotFoundException | SQLException e) {			}
			
			if(p != null) {
				HttpSession session = request.getSession();
				session.setAttribute("player", p);
//				session.setAttribute("player", new Player("Umang", "umng", "Ind", "bat", "Lions"));
				response.sendRedirect("HomeServlet");
			} else {
				response.sendRedirect("Index?result=errorMsg");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


