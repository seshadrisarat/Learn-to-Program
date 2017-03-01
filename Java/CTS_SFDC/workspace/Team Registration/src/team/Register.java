package team;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String outData = "<html><body>";
			
			try {
				if((new TeamDAO().createTeam(
						new Team(
								request.getParameter("name"),
								request.getParameter("coach"),
								new CityBO().getCityByName(
										request.getParameter("city")
										)
								)
						)
					) == 1 ) {
				}
			} catch (ClassNotFoundException | SQLException e) {			}
			

			outData += "<h2>Team Registered Successfully</h2>";
			outData += "<br>"
					+ "<a id='home' href='index.jsp'>Home</a>"
					+ "</body></html>";
			
			response.getWriter().print(outData);
	}
}


