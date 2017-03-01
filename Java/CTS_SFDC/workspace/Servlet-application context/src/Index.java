

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String outData = "";
		
		String click = "";
		click = request.getParameter("click");
		
		if(click == null) {		
			session.setAttribute("msd", 0);
			session.setAttribute("jadeja", 0);
			session.setAttribute("kohli", 0);
			session.setAttribute("rohit", 0);
		} else {
			if(click.equals("msd")) {
				session.setAttribute("msd", (int)session.getAttribute("msd") + 1);
			} else if(click.equals("jadeja")) {
				session.setAttribute("jadeja", (int)session.getAttribute("jadeja") + 1);
			} else if(click.equals("kohli")) {
				session.setAttribute("kohli", (int)session.getAttribute("kohli") + 1);
			} else if(click.equals("rohit")) {
				session.setAttribute("rohit", (int)session.getAttribute("rohit") + 1);
			}
		}
		
		outData = "<html>"
				+ "<head>"
				+ "<title>Players</title>"
				+ "<style>img{width:100px;height:100px;}</style>"
				+ "</head>"
				+ "<body>"
				+ "<h3>Players</h3>"
				+ "<table id='player' border='1'>"
				+ "<tbody>"
				+ "<tr>"
				+ "<td><img src='images/msd.jpg' /><br>" + session.getAttribute("msd") + " Followers<br><a href='Index?click=msd' >Follow</a></td>"
				+ "<td><img src='images/jadeja.jpg' /><br>" + session.getAttribute("jadeja") + " Followers<br><a href='Index?click=jadeja' >Follow</a></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td><img src='images/kohli.jpg' /><br>" + session.getAttribute("kohli") + " Followers<br><a href='Index?click=kohli' >Follow</a></td>"
				+ "<td><img src='images/rohit.jpg' /><br>" + session.getAttribute("rohit") + " Followers<br><a href='Index?click=rohit' >Follow</a></td>"
				+ "</tr>"
				+ "</tbody>"
				+ "</table>"
				+ "</body</html>";		
		
		response.getWriter().print(outData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
