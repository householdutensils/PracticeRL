package net.householdutensils.practicerl;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class PracticeUIHandler {
	
	private static int NUM_RENDER_LOGS = 4;
	private static int BASE_LOG_RENDER_Y = 21;
	private static int BASE_LOG_RENDER_X = 1;
	
	PracticeRougeLike practiceRougeLike;
	
	public PracticeUIHandler(PracticeRougeLike practiceRougeLike) {
		this.practiceRougeLike = practiceRougeLike;
	}



	public void render(ConsoleSystemInterface csi, PracticeCharacter playerCharacter, PracticeGameLog practiceGameLog, PracticeMap practiceMap) {
		
    	renderPrimaryUI(csi, playerCharacter, practiceMap);
    	
    	renderGameLog(csi, practiceGameLog);

	}
	
	
	
	private void renderGameLog(ConsoleSystemInterface csi, PracticeGameLog practiceGameLog) {
		
		int lastLogIndex = practiceGameLog.getLogList().size() - 1;
    	
    	if (lastLogIndex > NUM_RENDER_LOGS) {
        	
    		for (int i = 0; i < NUM_RENDER_LOGS; i++) {
        	
    			csi.print(BASE_LOG_RENDER_X, BASE_LOG_RENDER_Y + i, practiceGameLog.getLogList().get(lastLogIndex - i), CSIColor.ALICE_BLUE); 
    			
        	}
    	
    	} else {
    		
    		for (int i = 0; i <= (practiceGameLog.getLogList().size() - 1); i++) {
            	
    			csi.print(BASE_LOG_RENDER_X, BASE_LOG_RENDER_Y + i, practiceGameLog.getLogList().get((practiceGameLog.getLogList().size() - 1) - i), CSIColor.ALICE_BLUE); 
    			
        	}
    		
    	}
		
	}
	
	
	
	private void renderPrimaryUI(ConsoleSystemInterface csi, PracticeCharacter playerCharacter, PracticeMap practiceMap) {
		
    	csi.print(62, 2, playerCharacter.getName(), CSIColor.AMARANTH);
    	csi.print(62, 3, "Map: " + practiceRougeLike.getCurrentMap() , CSIColor.AMARANTH);
    	csi.print(62, 4, "Direction: " + playerCharacter.getPlayerDirection(), CSIColor.AMARANTH);
    	csi.print(62, 5, "NPCS: " + practiceMap.getNumNPCs(), CSIColor.AMARANTH);
    	csi.print(62, 6, "XP: " + playerCharacter.getPlayerXP(), CSIColor.AMARANTH);
		
	}

}
