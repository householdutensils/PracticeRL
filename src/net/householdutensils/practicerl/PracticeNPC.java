package net.householdutensils.practicerl;

import net.slashie.libjcsi.CSIColor;

public class PracticeNPC {
	
	
	
	
	
	int npcX;
	int npcY;
	String npcChar;
	int npcType;
	String npcName;
	CSIColor npcColor;
	int npcStatus;
	int npcMap;
	
	
	public PracticeNPC(String nChar, int startX, int startY, int nType, String nName, CSIColor nColor, int nStatus, int nMap) {
		
		npcX = startX;
		npcY = startY;
		npcChar = nChar;
		npcType = nType;
		npcName = nName;
		npcColor = nColor;
		npcStatus = nStatus;
		npcMap = nMap;
		
	}
	

	public int getNPCMap() {
		
		return npcMap;
		
	}

	public void setNPCMap(int npcMap) {
		
		this.npcMap = npcMap;
		
	}

	
	public int getNPCStatus() {
		
		return npcStatus;
		
	}

	public void setNPCStatus(int nStatus) {
		
		npcStatus = nStatus;
		
	}
	
	public CSIColor getColor() {
		
		return npcColor;
		
	}
	
	public int getX() {
		
		return npcX;

	}
	
	public int getY() {
		
		return npcY;
		
	}
	
	public String getChar() {
		
		return npcChar;
		
	}
	
	public void setX(int newX) {
		
		npcX = newX;
		
	}
	
	public void move(int moveX, int moveY) {
		
		npcX = npcX + moveX;
		npcY = npcY + moveY;
		
	}
	
	public void setY(int newY) {
		
		npcY = newY;
		
	}


	public int getType() {
		return npcType;
	}
	
	public String getNpcName() {
		return npcName;
	}


	public void setNpcName(String npcName) {
		this.npcName = npcName;
	}


	
	
}
