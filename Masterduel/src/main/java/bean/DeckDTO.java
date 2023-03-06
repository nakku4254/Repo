package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class DeckDTO implements Serializable{
  private ArrayList<DeckBean> list;

  public DeckDTO(){
    list = new ArrayList<DeckBean>();
  }
  public void add(DeckBean sb){
    list.add(sb);
  }
  public DeckBean get(int i){
    return list.get(i);
  }
  public int size(){
    return list.size();
  }
}

