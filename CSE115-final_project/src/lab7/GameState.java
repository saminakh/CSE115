package lab7;

import java.util.ArrayList;

public class GameState {

	private ArrayList<ArrayList<String>> _myList;
	
	public GameState(){
		
		_myList = new ArrayList<ArrayList<String>>();
	
		for(int x=0; x<6;  x=x+1){		
		ArrayList<String> al = new ArrayList<String>();	
			for(int y=0; y<7; y=y+1){
				al.add("e");
			}
			
		_myList.add(al);
		}
	}
	
	public void setList(ArrayList<ArrayList<String>> myList) {
	       _myList = myList;
	}
	
	public ArrayList<ArrayList<String>> getList() {	    	
	        return _myList;
	}	
	
}
		
		
	