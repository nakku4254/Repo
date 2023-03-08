package bean;

import java.io.Serializable;

public class DeckBean implements Serializable {
	private int id;
	private String deck;
	private int win;
	private int lose;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeck() {
		return deck;
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

}