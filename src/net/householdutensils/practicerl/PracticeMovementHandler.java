package net.householdutensils.practicerl;

import java.util.ArrayList;

import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.textcomponents.TextBox;

public class PracticeMovementHandler {
	
	
	PracticeCollisionDetection practiceCollisionDetection;
	PracticeGameLog practiceGameLog;

	public PracticeMovementHandler(PracticeCollisionDetection practiceCollisionDetection, PracticeGameLog practiceGameLog) {
		this.practiceCollisionDetection = practiceCollisionDetection;
		this.practiceGameLog = practiceGameLog;
	}

	public void exploreHandler(ConsoleSystemInterface csi, PracticeCharacter playerCharacter, ArrayList<PracticeNPC> practiceNPCs, PracticeGameLog practiceGameLog, PracticeMap practiceMap, PracticeRougeLike practiceRougeLike) {
		
		int key = csi.inkey().code;
		
		switch (key){
        
        case CharKey.UARROW:
        	
        	
        		if (!practiceCollisionDetection.playerNPCAttackCheck(this, PracticeCharacter.MOVE_NORTH, practiceMap, practiceNPCs, playerCharacter, csi)) {     
        			
	        		if (!practiceCollisionDetection.playerMoveCheck(PracticeCharacter.MOVE_NORTH, practiceMap, practiceNPCs, playerCharacter)) {
	        			
	        			playerCharacter.move(PracticeCharacter.MOVE_NORTH, practiceMap);	
	        			
	        		}
		
        			
        		}


				practiceRougeLike.playerTurn = false;

	        	playerCharacter.setPlayerDirection(PracticeCharacter.DIR_NORTH);	
        	break;
        case CharKey.DARROW:
	
	    		if (!practiceCollisionDetection.playerNPCAttackCheck(this, PracticeCharacter.MOVE_SOUTH, practiceMap, practiceNPCs, playerCharacter, csi)) {     
	
		    		if (!practiceCollisionDetection.playerMoveCheck(PracticeCharacter.MOVE_SOUTH, practiceMap, practiceNPCs, playerCharacter)) {
		
			        	playerCharacter.move(PracticeCharacter.MOVE_SOUTH, practiceMap);
						
		    		}
	    		}
		        
	    		practiceRougeLike.playerTurn = false;
	
	        	playerCharacter.setPlayerDirection(PracticeCharacter.DIR_SOUTH);
        	break;
        case CharKey.LARROW:        			
    			
	    		if (!practiceCollisionDetection.playerNPCAttackCheck(this, PracticeCharacter.MOVE_WEST, practiceMap, practiceNPCs, playerCharacter, csi)) {     
	
		        	if (!practiceCollisionDetection.playerMoveCheck(PracticeCharacter.MOVE_WEST, practiceMap, practiceNPCs, playerCharacter)) {
		
		        			playerCharacter.move(PracticeCharacter.MOVE_WEST, practiceMap);
						
		    		}
		        	
	    		}
				practiceRougeLike.playerTurn = false;
	        				
	        	playerCharacter.setPlayerDirection(PracticeCharacter.DIR_WEST);
        	break;
        case CharKey.RARROW:
    		
	    		if (!practiceCollisionDetection.playerNPCAttackCheck(this, PracticeCharacter.MOVE_EAST, practiceMap, practiceNPCs, playerCharacter, csi)) {     
	
	        		if (!practiceCollisionDetection.playerMoveCheck(PracticeCharacter.MOVE_EAST, practiceMap, practiceNPCs, playerCharacter)) {
	
	        			playerCharacter.move(PracticeCharacter.MOVE_EAST, practiceMap);
					
	        		}
	        		
	    		}
				practiceRougeLike.playerTurn = false;
	
	        	playerCharacter.setPlayerDirection(PracticeCharacter.DIR_EAST);
        	break;
        case CharKey.C:
        	
        	practiceCollisionDetection.playerTalkCheck(PracticeCharacter.MOVE_EAST, practiceMap, practiceNPCs, playerCharacter);
      	
        	break;
        case CharKey.Q:
        	practiceRougeLike.exit = true;
        	practiceRougeLike.stop = true;
        }
       
    	
	}
	
	public boolean attackConfirm(ConsoleSystemInterface csi, PracticeNPC practiceNPC) {
		
		TextBox t = new TextBox(csi);
		t.setWidth(50);
		t.setHeight(3);
		t.setBorder(true);
		t.setPosition(5,5);
		t.setText("Are you sure you want to attack " + practiceNPC.getNpcName() + "?(y/n)");
		t.draw();
		
		csi.refresh();
				
		int charkey = csi.inkey().code;
		
		
		switch (charkey) {
		
		case CharKey.y:
			t.clear();
			return true;
		case CharKey.n:
			t.clear();
			return false;
		
		}
		t.clear();
		return false;
		
	}

	
	
}
