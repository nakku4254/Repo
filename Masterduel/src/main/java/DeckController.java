import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DeckDTO;

@WebServlet("/servlet")
public class DeckController extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {

	    req.setCharacterEncoding("utf-8");
	    String action = req.getParameter("action");
	    String deck = req.getParameter("deckName");
	    String deckId = req.getParameter("deck");
	    
	    DAO ddao = new DAO();
	    
	    if(!(action == null)) {
	    	if(action.equals("delete")) {	    		
	    		ddao.delete(Integer.parseInt(deckId));
	    	}
	    }else {
	    	ddao.insert(deck);
	    }
 
	    //全件検索
	    DeckDTO ddto = ddao.select();
	    //リクエストスコープにDTOとmsgを格納
	    req.setAttribute("ddto", ddto);
	    
	    RequestDispatcher rd = req.getRequestDispatcher("/deckList.jsp");
	    rd.forward(req, res);
  }
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
	  DAO ddao = new DAO();
	  DeckDTO ddto = ddao.select();
	  req.setAttribute("ddto", ddto);
	  RequestDispatcher rd = req.getRequestDispatcher("/deckManeger.jsp");
	  rd.forward(req, res);
	  
  }
}
