package dotCom;

import java.util.*;
public class DotCom{
	private ArrayList<String> locationCells;
	private String name;
//	int[] locationCells;
//	int numOfHits = 0;
	public void setLocationCells(ArrayList<String> loc){
		locationCells = loc;
	}
	public void setName(String n) {
		name = n;
	}
	public String checkYourself(String userInput){
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if(index >= 0) {
			locationCells.remove(index);
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("你击沉了" + name + " : (");
			}else {
				result = "hit";
			}//停止if判断
		}
//		int guess = Integer.parseInt(stringGuess);
		/*
		 * String result = "miss"; for (int cell : locationCells){ if (guess == cell){
		 * result = "hit"; numOfHits++; break; } } if (numOfHits ==
		 * locationCells.length){ result = "kill"; } System.out.println(result); return
		 * result;
		 */
		return result;
	}
}