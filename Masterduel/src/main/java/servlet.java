import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DeckDTO;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {


    req.setCharacterEncoding("utf-8");
    String deck = req.getParameter("deck");
    //StudentDAOオブジェクトを生成
    DAO ddao = new DAO();
    ddao.insert(deck,0,0);

    
    //全件検索
    DeckDTO ddto = ddao.select();
    //リクエストスコープにDTOとmsgを格納
    req.setAttribute("ddto", ddto);
    
    RequestDispatcher rd = req.getRequestDispatcher("/view.jsp");
    rd.forward(req, res);
  }
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
	  DAO ddao = new DAO();
	  DeckDTO ddto = ddao.select();
	    req.setAttribute("ddto", ddto);
	  RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
	  rd.forward(req, res);
	  
  }
}
