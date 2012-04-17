package net.householdutensils.practicerl;

import java.util.ArrayList;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class PracticeConversation {

	boolean currentConversation;
	int npcIndex;
	int speechSelection;
	
	public PracticeConversation() {
	
		currentConversation = false;
		
	
	}

	public boolean existsCurrent() {

		return currentConversation;
	}

	public void newConversation(int converseNPCIndex) {
		
		currentConversation = true;
		npcIndex = converseNPCIndex;
		speechSelection = 0;

	}
	
	public void endConversation() {
		
		currentConversation = false;
		npcIndex = (Integer) null;
		
	}

	
	public void renderConversation(ArrayList<PracticeNPC> practiceNPCs, ConsoleSystemInterface csi) {
		
		
		csi.print(1, 1, "Hello!", CSIColor.ALICE_BLUE);
		
		if (speechSelection == 0) {
				
			csi.print(1, 3, "Hi!", CSIColor.AMARANTH);

		} else {
			
			csi.print(1, 3, "Hi!", CSIColor.AMBER);
			
		}
		
		if (speechSelection == 1) {
			
			csi.print(1, 4, "Bye!", CSIColor.AMARANTH);

			
		} else {
			
			csi.print(1, 4, "Bye!", CSIColor.AMBER);
			
		}
		
		if (speechSelection == 2) {
			
			csi.print(1, 5, "DIE!", CSIColor.AMARANTH);
			
		} else {
			
			csi.print(1, 5, "DIE!", CSIColor.AMBER);
			
		}
		
	}

	public void controlHandler(ConsoleSystemInterface csi, PracticeRougeLike practiceRougeLike) {
		
		int key = csi.inkey().code;
		
		switch (key){
			case CharKey.DARROW:
				speechSelection ++;
				break;
			case CharKey.UARROW:
				speechSelection --;
				break;
			case CharKey.Q:
			practiceRougeLike.exit = true;
			practiceRougeLike.stop = true;
			
		}
        
		
		
		
	}
	
}
