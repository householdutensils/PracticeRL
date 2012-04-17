package net.householdutensils.practicerl;

 
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.jcurses.JCursesConsoleInterface;
import net.slashie.libjcsi.textcomponents.TextBox;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import java.util.ArrayList;
import java.util.Random;

public class PracticeRougeLike {

    private ConsoleSystemInterface csi = new WSwingConsoleInterface("Practice Rogue", true);

    PracticeCharacter playerCharacter = new PracticeCharacter(30, 10, "@", "Derp teh Derp", 1, PracticeCharacter.DIR_NORTH);
    
    PracticeNPCHandler practiceNPCHandler = new PracticeNPCHandler(this);
    
    PracticeUIHandler practiceUIHandler = new PracticeUIHandler(this);
    
    PracticeGameLog practiceGameLog = new PracticeGameLog(this);
    
    PracticeCollisionDetection practiceCollisionDetection = new PracticeCollisionDetection(this, practiceGameLog);
        
    PracticeMapGenerator practiceMapGenerator = new PracticeMapGenerator(this, playerCharacter);
    
    PracticeMovementHandler practiceMovementHandler = new PracticeMovementHandler(practiceCollisionDetection, practiceGameLog);
      
    public String[] mArray;
    
    boolean stop;
    
    boolean playerTurn;
    
    boolean exit;
    
    public int gameMode;
     
    public static int MODE_EXPLORE = 0;
    public static int MODE_CONVERSE = 1;
    
    public int currentMap;
    
 
	public int converseNPCIndex;   
    
    public static void main(String[] p) {
    	new PracticeRougeLike().startNewGame();
    }
 
    public void startNewGame() {
    	
    	exit = false;
    	currentMap = 0;
    	this.start();
    	
    }
    
    public PracticeMap loadMap(int mapId) {

    	if (mapId == 0) {
    		
    		return practiceMapGenerator.randomWalkGen(mapId);

    	} else {
    		
    	    return practiceMapGenerator.genMap(mapId);
	
    	}
        

    }

    
    public void start () {
    	
    	PracticeMap practiceMap;
    	
    	csi.cls();
        csi.saveBuffer();
        
        while (!exit) {
        	
        	practiceMap = this.loadMap(currentMap);
	                
	        gameMode = MODE_EXPLORE;      
	        playerTurn = true;
	    	converseNPCIndex = 0;
	    	stop = false;
	    	
	        this.gameLoop(practiceMap);
        
        }
        
        System.exit(0);
    }
    
    
    
    public void gameLoop(PracticeMap practiceMap) {
    	
        while (!stop){
        	        		
	        	playerTurn = true;
	        	//csi.restore();
	        	csi.cls();
	
	        	practiceMap.render(csi, playerCharacter, practiceMap.getPracticeNPCs(), practiceNPCHandler);
	        	
	        	playerCharacter.render(csi);
	
	        	practiceNPCHandler.renderNPCs(practiceMap.getPracticeNPCs(),csi, playerCharacter, practiceMap);
	        	
	        	practiceUIHandler.render(csi, playerCharacter, practiceGameLog, practiceMap);
	        	
	            csi.refresh(); 
	            
	            practiceMovementHandler.exploreHandler(csi, playerCharacter, practiceMap.getPracticeNPCs(), practiceGameLog, practiceMap, this);

	            if (!playerTurn) {
	            	practiceNPCHandler.moveNPCs(practiceMap.getPracticeNPCs(), csi, playerCharacter, practiceGameLog, practiceMap);
	            }

        }
        
    	
    }
    
    public int getCurrentMap() {
 		return currentMap;
 	}

 	public void setCurrentMap(int currentMap) {
 		this.currentMap = currentMap;
 	}
    
}