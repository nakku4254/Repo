import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DeckDTO;

@WebServlet("/DeleteServlet")         
public class DeckDeleteServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		req.setCharacterEncoding("utf-8");
		String deckId = req.getParameter("deckId");
		String deckName = req.getParameter("deckName");
		String msg = deckName + "を削除しました。";

		//StudentDAOオブジェクトを生成
		DAO ddao = new DAO();
		//デッキ名追加
		ddao.delete(Integer.parseInt(deckId));
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