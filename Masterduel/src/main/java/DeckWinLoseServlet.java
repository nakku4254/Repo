import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DeckDTO;

@WebServlet("/WinLoseServlet")         
public class DeckWinLoseServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		req.setCharacterEncoding("utf-8");
		String deckId = req.getParameter("deckId");
		String deckName = req.getParameter("deckName");
		String winLose = req.getParameter("winLose");
		String msg = deckName + "を更新しました。";

		//StudentDAOオブジェクトを生成
		DAO ddao = new DAO();
		//デッキ名追加
		ddao.update(Integer.parseInt(deckId),winLose);
		//全件検索
		DeckDTO ddto = ddao.select();
		//リクエストスコープにDTOとmsgを格納
		req.setAttribute("ddto", ddto);
		req.setAttribute("msg", msg);

		RequestDispatcher rd = req.getRequestDispatcher("/deckEditConfirm.jsp");
		rd.forward(req, res);
	}
  
  public void doGet(HttpServletRequest req, HttpServletResponse res)
	      throws IOException, ServletException {	  
	  }
}