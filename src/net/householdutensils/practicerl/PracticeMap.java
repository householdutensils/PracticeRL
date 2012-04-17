package net.householdutensils.practicerl;

import java.util.ArrayList;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class PracticeMap {

	
    public static int MAP_HEIGHT = 200;
    public static int MAP_WIDTH = 200;
    
    public static int WINDOW_WIDTH = 60;
    public static int WINDOW_HEIGHT = 20;
    
    public int windowX;
    
    public int numNPCs = 0;
    



	public int windowY;
    
    public static int TILE_BLANK = 0;
    public static int TILE_WALL = 1;
    public static int TILE_DOOR_CLOSED = 2;
    public static int TILE_DOOR_OPEN = 3;
    public static int TILE_STAIRS_DOWN = 4;
    public static int TILE_STAIRS_UP = 5;
    
	public String[] tileArray = {".", "#", "+", "/", ">", "<"};
	
    ArrayList<PracticeNPC> practiceNPCs = new ArrayList<PracticeNPC>();

	public static String wallString = "#";
    public static String downStairString = ">";
    
    int[][] mapIntArray = new int[MAP_WIDTH + 1][MAP_HEIGHT + 1];
    
	int[][] mapSeenArray = new int[MAP_WIDTH + 1][MAP_HEIGHT + 1];
	
	int[][] mapWindowArray = new int[WINDOW_WIDTH + 1][WINDOW_HEIGHT + 1];

   
	public void setWindowY(int windowY) {
		this.windowY = windowY;
	}

	public PracticeMap(PracticeRougeLike practiceRougeLike) {
	
		windowX = 0;
		windowY = 0;
	
	}
	
   
	 public int getNumNPCs() {
			return numNPCs;
		}


		public void setNumNPCs(int numNPCs) {
			this.numNPCs = numNPCs;
		}


		public int getWindowX() {
			return windowX;
		}


		public void setWindowX(int windowX) {
			this.windowX = windowX;
		}


		public int getWindowY() {
			return windowY;
		}

	
    public ArrayList<PracticeNPC> getPracticeNPCs() {
		return practiceNPCs;
	}


	public void setPracticeNPCs(ArrayList<PracticeNPC> practiceNPCs) {
		this.practiceNPCs = practiceNPCs;
	}
    
    public int[][] getMapIntArray() {
		return mapIntArray;
	}

	public void setMapIntArray(int[][] mapIntArray) {
		this.mapIntArray = mapIntArray;
	}

	public int[][] getMapSeenArray() {
		return mapSeenArray;
	}

	public void setMapSeenArray(int[][] mapSeenArray) {
		this.mapSeenArray = mapSeenArray;
	}

	
	public int getMapArrayItem(int mapX, int mapY) {
		
		return mapIntArray[mapX][mapY];
		
	}
	
	
	public void render(ConsoleSystemInterface csi, PracticeCharacter playerCharacter, ArrayList<PracticeNPC> practiceNPCs, PracticeNPCHandler practiceNPCHandler) {
		
		for(int w = 0; w <= WINDOW_WIDTH; w++) {
			
			for(int h = 0; h <= WINDOW_HEIGHT; h++) {
				
				if (windowX + w >= 0 && windowY + h >= 0) {
					
					if (windowX + w <= MAP_WIDTH && windowY + h <= MAP_HEIGHT) {
						
						if (!((windowX + w <= MAP_WIDTH - 1 && windowY + h <= MAP_HEIGHT - 1)
							&& (windowX + w >= 1 && windowY + h >= 1)
							&& (mapIntArray[windowX + w + 1][windowY + h] == TILE_WALL)
							&& (mapIntArray[windowX + w - 1][windowY + h] == TILE_WALL)
							&& (mapIntArray[windowX + w][windowY + h + 1] == TILE_WALL)
							&& (mapIntArray[windowX + w][windowY + h - 1] == TILE_WALL))) {
							
							
							if ((w < playerCharacter.getX() +  4 && w > playerCharacter.getX() - 4)
								&& (h < playerCharacter.getY() + 4 && h > playerCharacter.getY() - 4)) {
								
								csi.print(w, h, tileArray[mapIntArray[windowX + w][windowY + h]], CSIColor.YELLOW);

								
							} else {
								
								csi.print(w, h, tileArray[mapIntArray[windowX + w][windowY + h]], CSIColor.DARK_GRAY);

							}
							

						}
						
					}
			
				}
	
			}
				
		}

	}

	

}
