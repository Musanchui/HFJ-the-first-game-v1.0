package dotCom;
import java.util.*;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	public void setUpGame() {
		//创建Dotcom对象
		DotCom one = new DotCom();
		one.setName("Baidu.com");
		DotCom two = new DotCom();
		two.setName("Tencent.com");
		DotCom three = new DotCom();
		three.setName("Alibat.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("你的目标是打倒三巨头");
		System.out.println("百度、腾讯、和阿里");
		System.out.println("尝试以最快的速度击沉他们");
		
		for(DotCom dotComToSet : dotComsList) {
			ArrayList<String>newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
			
		}
	}
	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("輸入你的猜測");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		
		for(DotCom dotComToTest :dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")){
				break;
			}
			if(result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	private void finishGame() {
		System.out.println("你消滅了所有巨頭！你勝利了");
		if(numOfGuesses <= 18) {
			System.out.println("你只用了" + numOfGuesses + "下！");
			System.out.println("這太棒了！");
		}else {
			System.out.println("居然用了" + numOfGuesses + "次哎？");
			System.out.println("太遜了！");
		}
	}
	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}