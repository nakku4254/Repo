package bean;

import java.io.Serializable;

public class DeckBean implements Serializable{
  private String deck;
  private int win;
  private int lose;
  
  public void setDeck(String deck){
    this.deck = deck;
  }
  public void setWin(int win){
	this.win = win;
  }
  public void setLose(int lose){
    this.lose = lose;
  }
  
  public String getDeck(){
    return deck;
  }
  public int getWin(){
    return win;
  }
  public int getLose(){
    return lose;
  }
}