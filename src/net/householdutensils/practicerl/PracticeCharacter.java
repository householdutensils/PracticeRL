package net.householdutensils.practicerl;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class PracticeCharacter {
	
	
	public final static int DIR_NORTH = 0;
	public final static int DIR_EAST = 1;
	public final static int DIR_SOUTH = 2;
	public final static int DIR_WEST = 3;
	
	
	public final static int MOVE_NORTH = 0;
	public final static int MOVE_EAST = 1;
	public final static int MOVE_SOUTH = 2;
	public final static int MOVE_WEST = 3;

	

	private int playerX;
	private int playerY;
	
	private String playerChar;
	private String playerName;
	private int playerClass;
	private int playerDirection;
	
	private int playerXP;
	
	public PracticeCharacter(int startX, int startY, String pChar, String pName, int pClass, int pDir) {
		
		playerX = startX;
		playerY = startY;
		playerChar = pChar;
		playerName = pName;
		playerClass = pClass;
		setPlayerDirection(pDir);
		
		playerXP = 0;
	}
	
	public int getPlayerXP() {
		return playerXP;
	}

	public void setPlayerXP(int playerXP) {
		this.playerXP = playerXP;
	}

	public void render(ConsoleSystemInterface csi) {
		
        csi.print(playerX, playerY, playerChar, CSIColor.ATOMIC_TANGERINE);
		
	}
	
	
	
	public int getX() {
		
		return playerX;
				
	}
	
	public int getY() {
		
		return playerY;
		
	}
	
	public String getChar() {
		
		return playerChar;
		
	}
	
	public String getName() {
		
		return playerName;
		
	}
	
	public int getCharacterClass() {
		
		return playerClass;
		
	}
	
	public void move(int moveDir, PracticeMap practiceMap) {
		int moveX = 0;
		int moveY = 0;
		
		switch (moveDir) {
		case MOVE_NORTH:
				moveY = -1;
			break;
		case MOVE_EAST:
				moveX = 1;
			break;
		case MOVE_SOUTH:
				moveY = 1;
			break;
		case MOVE_WEST:
				moveX = -1;
			break;		
		}
		
		practiceMap.setWindowX(practiceMap.getWindowX() + moveX);
		practiceMap.setWindowY(practiceMap.getWindowY() + moveY);
		
	}

	public void setX(int x) {
		playerX = x;	
	}

	public void setY(int y) {
		playerY = y;		
	}

	public int getPlayerDirection() {
		return playerDirection;
	}

	public void setPlayerDirection(int playerDirection) {
		this.playerDirection = playerDirection;
	}

	public void addPlayerXP(int i) {
		
		playerXP += i;
		
	}


}
