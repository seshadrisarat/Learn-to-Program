

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String runs = request.getParameter("runs");
		String average = request.getParameter("average");
		int count=0;
		String regex = "^[a-zA-Z]+$";
		String output = "<!DOCTYPE html><html><body><div id='error'>";
		if(!name.matches(regex)){
			output+="Invaild Name<br>";
			count++;
		}
		String ePattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(!email.matches(ePattern)){
			output+="Invaild Email<br>";
			count++;
		}
		if(!dob.matches("\\d{2}/\\d{2}/\\d{4}")){
			output+="Invaild DOB<br>";
			count++;
		}
		if(!runs.matches("[-+]?\\d*\\.?\\d+")){
			output+="Invaild runs<br>";
			count++;
		}
		if(!average.matches("^\\d+\\.\\d{2}$")){
			output+="Invaild Average<br>";
			count++;
		}
		output+="</div></body></html>";
		if(count==0){
			out.print("<b>Inserted Successfully !!!</b>");
		}
		else{
			out.println(output);
			out.print("<br><a id=\"home\" href=\"index.html\">&lt&ltHome</a>");
		}
	}

}
