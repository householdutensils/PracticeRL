package net.householdutensils.practicerl;

public class PracticeMonster {

	int x;
	int y;
	String monsterChar;
	
	public PracticeMonster(String string, int startX, int startY) {
		
		x = startX;
		y = startY;
		monsterChar = string;

	}

	
	public int getX() {
		
		return x;
		
		
	}
	
	public int getY() {
		
		return y;
		
	}
	
	public String getChar() {
		
		return monsterChar;
		
	}
	
	public void setX(int newX) {
		
		x = newX;
		
	}
	
	public void setY(int newY) {
		
		y = newY;
		
	}
	

}
