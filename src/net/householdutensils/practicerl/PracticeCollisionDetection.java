package net.householdutensils.practicerl;

import java.util.ArrayList;

import net.slashie.libjcsi.ConsoleSystemInterface;

public class PracticeCollisionDetection {
	
	PracticeRougeLike practiceRougeLike;
	PracticeGameLog practiceGameLog;

	public PracticeCollisionDetection(PracticeRougeLike practiceRougeLike, PracticeGameLog practiceGameLog) {
		this.practiceRougeLike = practiceRougeLike;
		this.practiceGameLog = practiceGameLog;
	}

	public boolean playerMoveCheck(int moveDir, PracticeMap practiceMap, ArrayList<PracticeNPC> practiceNPCs, PracticeCharacter playerCharacter) {
		
		int xOffset = 0;
		int yOffset = 0;
		
		switch (moveDir) {
			case PracticeCharacter.MOVE_NORTH:
				yOffset = -1;
			break;
			case PracticeCharacter.MOVE_EAST:
				xOffset = 1;
			break;
			case PracticeCharacter.MOVE_SOUTH:
				yOffset = 1;
			break;
			case PracticeCharacter.MOVE_WEST:
				xOffset = -1;
			break;		
			
		}
		
		
		
		if (practiceMap.getMapArrayItem((practiceMap.getWindowX() + (playerCharacter.getX() + xOffset)), (practiceMap.getWindowY() + (playerCharacter.getY() + yOffset))) != PracticeMap.TILE_WALL) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
		
	}

	public void playerTalkCheck(int moveEast, PracticeMap practiceMap, ArrayList<PracticeNPC> practiceNPCs, PracticeCharacter playerCharacter) {
		
		for(int i = 0; i <= (practiceNPCs.size() - 1); i++) {
			
			if (practiceNPCs.get(i).getNPCStatus() == 1 && practiceNPCs.get(i).getNPCMap() == practiceRougeLike.currentMap) {
			
				
				boolean talkToChar = false;
				
				if ((practiceNPCs.get(i).getX() == (practiceMap.getWindowX() + (playerCharacter.getX() - 1)) && (practiceNPCs.get(i).getY() == (practiceMap.getWindowY() + (playerCharacter.getY()))))) {
					
					talkToChar = true;
					
				} else if ((practiceNPCs.get(i).getX() == (practiceMap.getWindowX() + (playerCharacter.getX() + 1)) && (practiceNPCs.get(i).getY() == (practiceMap.getWindowY() + (playerCharacter.getY()))))) {

					talkToChar = true;
					
				} else if ((practiceNPCs.get(i).getX() == (practiceMap.getWindowX() + (playerCharacter.getX())) && (practiceNPCs.get(i).getY() == (practiceMap.getWindowY() + (playerCharacter.getY() - 1))))) {
	
					talkToChar = true;
					
				} else if ((practiceNPCs.get(i).getX() == (practiceMap.getWindowX() + (playerCharacter.getX())) && (practiceNPCs.get(i).getY() == (practiceMap.getWindowY() + (playerCharacter.getY() + 1))))) {

					talkToChar = true;
				}
				
				if (talkToChar) {
									practiceGameLog.addLogLine("You Talk To Something");

				}
				

				
				
			}
		
		}
		
	}

	public boolean playerNPCAttackCheck(PracticeMovementHandler practiceMovementHandler, int moveDir, PracticeMap practiceMap,	ArrayList<PracticeNPC> practiceNPCs,PracticeCharacter playerCharacter, ConsoleSystemInterface csi) {
		
		
				int xSpeed = 0;
				int ySpeed = 0;
				
				
				switch(moveDir) {
				
					case PracticeCharacter.MOVE_NORTH:
						xSpeed = 0;
						ySpeed = -1;
						break;
					case PracticeCharacter.MOVE_EAST:
						xSpeed = 1;
						ySpeed = 0;
						break;
					case PracticeCharacter.MOVE_SOUTH:
						xSpeed = 0;
						ySpeed = 1;
						break;
					case PracticeCharacter.MOVE_WEST:
						xSpeed = -1;
						ySpeed = 0;
						break;	
				
				}
		
		
		
		for ( int t = 0; t <= (practiceNPCs.size() - 1); t++ ) {
			
			if (practiceNPCs.get(t).getNPCStatus() == 1 && practiceNPCs.get(t).getNPCMap() == practiceRougeLike.currentMap) {
							
				
				if ((practiceNPCs.get(t).getX() == (practiceMap.getWindowX() + (playerCharacter.getX() + xSpeed)) && (practiceNPCs.get(t).getY() == (practiceMap.getWindowY() + (playerCharacter.getY() + ySpeed))))) {
				
					
					
					if ((practiceNPCs.get(t).getType() != 100)) {
						
						
						if (practiceMovementHandler.attackConfirm(csi, practiceNPCs.get(t))) {
							
							practiceNPCs.get(t).setNPCStatus(0);
							practiceGameLog.addLogLine("You killed.....something");
							return true;
							
						} else {
							
							return true;
							
						}
						
						
						
					} 
						
					practiceGameLog.addLogLine("Good Kill!");
					playerCharacter.addPlayerXP(25);
					practiceNPCs.get(t).setNPCStatus(0);

						return true;
				} 				
				
			}
			
		}
		
		
		return false;
	}

	
	
}
