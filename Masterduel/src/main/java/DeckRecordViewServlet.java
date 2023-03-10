import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")         
public class DeckRecordViewServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {


		RequestDispatcher rd = req.getRequestDispatcher("/deckMatchRecord.jsp");
		rd.forward(req, res);
	}
  
  public void doGet(HttpServletRequest req, HttpServletResponse res)
	      throws IOException, ServletException {	  
		RequestDispatcher rd = req.getRequestDispatcher("/deckMatchRecord.jsp");
		rd.forward(req, res);
	  }
}