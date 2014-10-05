package ladderGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LadderGame {
	
	private int playerCount;
	private static int maxLineCount;
	
	private List<Player> playerList;

	public LadderGame(int playerCount, int maxLineCount) {		
		this.playerCount = playerCount;
		LadderGame.maxLineCount = maxLineCount;
		
		playerList = new ArrayList<Player>();
		
		initGame();
	}
	
	private void initGame(){
		for(int i=1; i <= playerCount; i++){
			playerList.add(getPlayer(i));
		}
	}
	
	private Player getPlayer(int playerNum){
		Player player = new Player(playerNum);
		
		addLine(player);
		
		System.out.println(player);
			
		return player;
	}
	
	private void setPrevPlayerInfo(Player player){
		int playerNum = player.getPlayerNum();
		int prevPlayNum = playerNum - 1;
		Player prevPlayer = playerList.get(prevPlayNum - 1);
		
		Set<Integer> set = prevPlayer.keySet();
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()){
			int prevLineIndex = it.next();
			if(prevPlayNum == prevPlayer.get(prevLineIndex)){
				player.addLine(prevLineIndex, prevPlayNum);
			}
		}
	}
	
	private void addLine(Player player){
		int playerNum = player.getPlayerNum();
		int realMaxLineCount = maxLineCount / 2;
		int currLineIndex = 0;

		if(playerNum != 1) {
			setPrevPlayerInfo(player);
		}
		
		if(playerNum != playerCount) {
			Random lineIndexRand = new Random();
			Random lineCountRand = new Random();
			int lineCount = lineCountRand.nextInt(realMaxLineCount) + 1;
					
			for(int i=0; i<lineCount; i++) {
				currLineIndex = lineIndexRand.nextInt(10) + 1;
				
				if(player.containsLineIndex(currLineIndex)){
					i--;
					continue;
				} 
				
				player.addLine(currLineIndex, playerNum);
			}
		}		
	}

	public int run(int playerNum) {
		
		Player currPlayer = playerList.get(playerNum - 1);
		int result = playerNum;
		
		for(int i=1; i <= maxLineCount; i++){
			if(currPlayer.containsLineIndex(i)){
				int currPlayerNum = currPlayer.get(i);
				
				if(currPlayerNum == result){
					result++;					
				} else {
					result--;
				}
				
				currPlayer = playerList.get(result - 1);
			}		
		}

		return result;
	}
	
	public static int getMaxLineCount(){
		return maxLineCount;
	}

}
