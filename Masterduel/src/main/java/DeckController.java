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
	    DAO ddao = new DAO();
	    DeckDTO ddto = ddao.select();

	    
	    
	    if(!(action == null)) {
	    	if(action.equals("delete")) {	    		
	    		RequestDispatcher rd = req.getRequestDispatcher("/deckDeleteConfirm.jsp");
	    	    String[] deckIdName = req.getParameter("deck").split(" ");
	    	    String deckId = deckIdName[0];
	    	    String deckName = deckIdName[1];
	    		req.setAttribute("deckName", deckName);
	    		req.setAttribute("deckId", deckId);	
	    		rd.forward(req, res);
	    	}else if(action.equals("create")) {
	    		RequestDispatcher rd = req.getRequestDispatcher("/deckCreateForm.jsp");
	    		rd.forward(req, res);
	    	}else if(action.equals("update")) {
	    		RequestDispatcher rd = req.getRequestDispatcher("/deckWinLoseForm.jsp");
	    	    String[] deckIdName = req.getParameter("deck").split(" ");
	    	    String deckId = deckIdName[0];
	    	    String deckName = deckIdName[1];
	    		req.setAttribute("deckName", deckName);
	    		req.setAttribute("deckId", deckId);
    		    rd.forward(req, res);
	    	}else if(action.equals("read")){
	    		RequestDispatcher rd = req.getRequestDispatcher("/deckRecordList.jsp");
	    		req.setAttribute("ddto", ddto);
    		    rd.forward(req, res);
	    	}
	    }
  }
  
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
	  

	  DAO ddao = new DAO();
	  //DB全検索
	  DeckDTO ddto = ddao.select();

	  req.setAttribute("ddto", ddto);

	  RequestDispatcher rd = req.getRequestDispatcher("/deckManeger.jsp");
	  rd.forward(req, res);
	  
  }
}
