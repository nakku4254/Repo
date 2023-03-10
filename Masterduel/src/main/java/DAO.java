import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.DeckBean;
import bean.DeckDTO;

public class DAO {
	private final String URL = "jdbc:mysql://localhost:3306/mydb";
	private final String USER = "root";
	private final String PASS = "nakku425";
	private Connection con = null;

	public void connect() {
		try {
			//㈰DBに接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			//㈭DBを切断
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DeckDTO select() {
		Statement stmt = null;
		ResultSet rs = null;
		DeckDTO ddto = new DeckDTO();
		String sql = "SELECT * FROM deck2";
		try {
			connect();
			//㈪ステートメントを生成
			stmt = con.createStatement();
			//㈫SQLを実行
			rs = stmt.executeQuery(sql);
			//㈬検索結果の処理
			while (rs.next()) {
				DeckBean db = new DeckBean();
				db.setId(rs.getInt("id"));
				db.setDeck(rs.getString("name"));
				db.setWin(rs.getInt("win"));
				db.setLose(rs.getInt("lose"));
				ddto.add(db);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return ddto;
	}

	public int insert(String name) {
		String sql = "INSERT INTO deck2 (name) VALUES ('" + name + "')";
		return executeSql(sql);
	}
	
	
	public int update(int id, String winLose) {
		String sql = null;
		if(winLose.equals("win")) {
			sql = "UPDATE deck2 SET win = win + 1 WHERE id = " + id;
		}else {
		    sql = "UPDATE deck2 SET lose = lose + 1 WHERE id = " + id;
		}
	return executeSql(sql);
	}
	
	
	public int delete(int id) {
	String sql = "DELETE FROM deck2 WHERE id = " + id;
	return executeSql(sql);
	}

	public int executeSql(String sql) {
		Statement stmt = null;
		int result = 0;
		try {
			connect();
			//㈪ステートメントを生成
			stmt = con.createStatement();
			//㈫SQLを実行
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return result;
	}


}
