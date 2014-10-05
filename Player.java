package ladderGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Player {
	
	private int playerNum;
	
	private Map<Integer, Integer> lineIndexMap;
	
	public Player(int playerNum){
		this.playerNum = playerNum;
		lineIndexMap = new HashMap<Integer, Integer>();
	}
	
	public void addLine(int lineIndex, int playerNum){
		lineIndexMap.put(lineIndex, playerNum);
	}	
	
	public boolean containsLineIndex(Integer lineIndex) {
		return lineIndexMap.containsKey(lineIndex);
	}

	public boolean containsPlayerNum(Integer playerNum) {
		return lineIndexMap.containsValue(playerNum);
	}

	public void addLines(Map<? extends Integer, ? extends Integer> m) {
		lineIndexMap.putAll(m);
	}

	public Set<Integer> keySet() {
		return lineIndexMap.keySet();
	}

	public Integer get(Integer key) {
		return lineIndexMap.get(key);
	}

	public int getPlayerNum(){
		return playerNum;
	}

	public Map<Integer, Integer> getLineIndexMap() {
		return lineIndexMap;
	}

	@Override
	public String toString() {
		return "Player [playerNum=" + playerNum + ", lineIndexMap="
				+ lineIndexMap + "]";
	}

}
