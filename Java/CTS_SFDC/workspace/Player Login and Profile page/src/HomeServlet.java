import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outData = "";
		
		Player player = (Player) request.getSession().getAttribute("player");
		
		outData += "<html>"
				+ "<head><title>Home</title></head>"
				+ "<body>"
				+ "<a href='HomeServlet'>Home</a>"
				+ "&nbsp;<a href='ProfileServlet'>My Profile</a>"
				+ "&nbsp;<a href='LogoutServlet'>Logout</a>"
				+ "<hr>"
				+ "<h2>Welcome " + player.getName() + "!!!</h2>"
				+ "</body>"
				+ "</html>";
		
		response.getWriter().print(outData);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


