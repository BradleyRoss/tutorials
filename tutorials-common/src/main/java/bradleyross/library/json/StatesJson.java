package bradleyross.library.json;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class StatesJson extends HttpServlet {
	/**
	 * Process request.
	 * @param request HTTP request object
	 * @param response HTTP response object
	 * @throws ServletException if problem with servlet
	 * @throws IOException if IO problems
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		works(request,response);
	}
	/**
	 * Process request.
	 * @param request HTTP request object
	 * @param response HTTP response object
	 * @throws ServletException if problem with servlet
	 * @throws IOException if IO problems
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		works(request, response);
		
		
	}
	/**
	 * Generate output.
	 * <p>The items in the JSON item use the entities country, state, name.</p>
	 * @param request HTTP request object
	 * @param response HTTP response object
	 * @throws IOException if io problems
	 * @throws ServletException if servlet problems
	 */
	protected void works(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		PrintWriter output = response.getWriter(); 
		output.println("{\"entries\" : [");
		output.println("{\"country\":\"US\", \"state\":\"NY\",\"name\":\"New York\"},");
		output.println("{\"country\":\"US\", \"state\":\"PA\", \"name\":\"Pennsylvania\"}");
		output.println("]}");
	}
	public StatesJson() { ; }

}
