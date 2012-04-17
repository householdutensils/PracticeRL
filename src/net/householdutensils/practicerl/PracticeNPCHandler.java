package net.householdutensils.practicerl;

import java.util.ArrayList;
import java.util.Random;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class PracticeNPCHandler {

	PracticeRougeLike practiceRougeLike;
	

	public PracticeNPCHandler(PracticeRougeLike practiceRougeLike) {
		this.practiceRougeLike = practiceRougeLike;
	}

	public void moveNPCs(ArrayList<PracticeNPC> practiceNPCs, ConsoleSystemInterface csi, PracticeCharacter playerCharacter, PracticeGameLog practiceGameLog, PracticeMap practiceMap) {
	
    	Random randGen = new Random();
    	
    	for (int g = 0; g <= (practiceNPCs.size() - 1); g++) {
    		
    		
    		//if ((practiceNPCs.get(g).getType() == 100) && (practiceNPCs.get(g).getNPCStatus() == 1) && (practiceNPCs.get(g).getNPCMap() == practiceRougeLike.getCurrentMap())) {
    		if ((practiceNPCs.get(g).getType() == 100) && (practiceNPCs.get(g).getNPCStatus() == 1) && (practiceNPCs.get(g).getNPCMap() == practiceRougeLike.getCurrentMap())) {
	
	    		int moveRand = (randGen.nextInt(30) + 1);
	
		    	switch (moveRand) {
		    	case 1:
		    		if (practiceNPCs.get(g).getX() > 0) {
		    				    			
		        		if (practiceMap.getMapArrayItem(practiceNPCs.get(g).getX() - 1, practiceNPCs.get(g).getY()) != PracticeMap.TILE_WALL) {
		        			
		        			boolean isAttackTurn = false;
		        			
		    	   			if ((practiceNPCs.get(g).getY() == playerCharacter.getY()) && ((practiceNPCs.get(g).getX() - 1) == playerCharacter.getX())) {
		        					
		        				practiceGameLog.addLogLine("Monster hit you!");
		        					
		        				isAttackTurn = true;
	
		        			}
		        			
		        			if(!isAttackTurn){
		        				
		        				practiceNPCs.get(g).move(-1,0);     	
	
		        			}
		        		
		        		}
			
		    		}
		    		break;
		    	case 2:
		    		if (practiceNPCs.get(g).getX() < PracticeMap.MAP_WIDTH) {
		    			
		        		if (practiceMap.getMapArrayItem(practiceNPCs.get(g).getX() + 1, practiceNPCs.get(g).getY()) != PracticeMap.TILE_WALL) {
	
		        			boolean isAttackTurn = false;
		        			
		    	   			if ((practiceNPCs.get(g).getY() == playerCharacter.getY()) && ((practiceNPCs.get(g).getX() + 1) == playerCharacter.getX())) {
		        					
		        				practiceGameLog.addLogLine("Monster hit you!");
		        					
		        				isAttackTurn = true;
	
		        			}
		        			
		        			if(!isAttackTurn){
		        				
			        			practiceNPCs.get(g).move(1,0);
	
		        			}
		        			
		    			
		        		}
		        		
		    		}
		    		break;
		    	case 3:
		    		if (practiceNPCs.get(g).getY() > 0) {
		    			
		        		if (practiceMap.getMapArrayItem(practiceNPCs.get(g).getX(), practiceNPCs.get(g).getY() - 1) != PracticeMap.TILE_WALL) {
	
		        			boolean isAttackTurn = false;
		        			
		    	   			if ((practiceNPCs.get(g).getX() == playerCharacter.getX()) && ((practiceNPCs.get(g).getY() - 1) == playerCharacter.getY())) {
		        					
		        				practiceGameLog.addLogLine("Monster hit you!");
		        					
		        				isAttackTurn = true;
	
		        			}
		        			
		        			if(!isAttackTurn){
		        				
			        			practiceNPCs.get(g).move(0,-1);
	
		        			}
		        				    			
		        		}
		        			
		    		}
		    		break;
		    	case 4:
		    		if (practiceNPCs.get(g).getY() < PracticeMap.MAP_HEIGHT) {
		        		
		    			if (practiceMap.getMapArrayItem(practiceNPCs.get(g).getX(), practiceNPCs.get(g).getY() + 1) != PracticeMap.TILE_WALL) {
		        			
		    				boolean isAttackTurn = false;
		        			
		    	   			if ((practiceNPCs.get(g).getX() == playerCharacter.getX()) && ((practiceNPCs.get(g).getY() + 1) == playerCharacter.getY())) {
		        					
		        				practiceGameLog.addLogLine("Monster hit you!");
		        					
		        				isAttackTurn = true;
	
		        			}
		        			
		        			if(!isAttackTurn){
		        				
			    				practiceNPCs.get(g).move(0,1);
	
		        			}
		    			
		        		}
		    			
		    		}
		    		break;    	
		    	}
		    	
    		}
    	}
	}

	public void renderNPCs(ArrayList<PracticeNPC> practiceNPCs, ConsoleSystemInterface csi, PracticeCharacter playerCharacter, PracticeMap practiceMap) {
		
		for(int w = 0; w <= PracticeMap.WINDOW_WIDTH; w++) {
			
			for(int h = 0; h <= PracticeMap.WINDOW_HEIGHT; h++) {
		
				if (practiceMap.getWindowX() + w >= 0 && practiceMap.getWindowY() + h >= 0) {
											
						for(int i = 0; i <= (practiceNPCs.size() - 1); i++) {
											
							if (practiceNPCs.get(i).getNPCStatus() == 1 && practiceNPCs.get(i).getNPCMap() == practiceRougeLike.currentMap) {
								
								if ((practiceNPCs.get(i).getX() == practiceMap.getWindowX() + w) && (practiceNPCs.get(i).getY() == practiceMap.getWindowY() + h)) {
									
									if ((w < playerCharacter.getX() +  4 && w > playerCharacter.getX() - 4)
											&& (h < playerCharacter.getY() + 4 && h > playerCharacter.getY() - 4)) {
										
										csi.print(w, h, practiceNPCs.get(i).getChar(), practiceNPCs.get(i).getColor());						

									}
							
								}			
								
							}
						
						}
						
					}
					
				}
	
			}
				
		}
		
	
	
	
}
