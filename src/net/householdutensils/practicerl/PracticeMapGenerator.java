package net.householdutensils.practicerl;

import java.util.Random;

import net.slashie.libjcsi.CSIColor;

public class PracticeMapGenerator {

	PracticeRougeLike practiceRougeLike;
	PracticeCharacter playerCharacter;
	
    public static int MAP_HEIGHT = PracticeMap.MAP_HEIGHT;
    public static int MAP_WIDTH = PracticeMap.MAP_WIDTH;
    
    public static int TILE_BLANK = PracticeMap.TILE_BLANK;
    public static int TILE_WALL = PracticeMap.TILE_WALL;
    public static int TILE_DOOR_CLOSED = PracticeMap.TILE_DOOR_CLOSED;
    public static int TILE_DOOR_OPEN = PracticeMap.TILE_DOOR_OPEN;
    public static int TILE_STAIRS_DOWN = PracticeMap.TILE_STAIRS_DOWN;
    public static int TILE_STAIRS_UP = PracticeMap.TILE_STAIRS_UP;
    
    
    public final static int DIR_NORTH = 0;
    public final static int DIR_EAST = 1;
    public final static int DIR_SOUTH = 2;
    public final static int DIR_WEST = 3;
    
    Random randomNumGen = new Random();
	
	public PracticeMapGenerator(PracticeRougeLike practiceRougeLike, PracticeCharacter playerCharacter) {
		
		this.practiceRougeLike = practiceRougeLike;
		this.playerCharacter = playerCharacter;
				
		
	}
	

	public PracticeMap genMap(int mapId) {
		PracticeMap practiceMap = new PracticeMap(practiceRougeLike);
		
		int[][] mapSeenArray = new int[MAP_WIDTH + 1][MAP_HEIGHT + 1];
		int[][] mapIntArray = new int[MAP_WIDTH + 1][MAP_HEIGHT + 1];
			
		
		
		
		//Map Generator 
		//Fill with Wall
		for ( int w = 0; w <= MAP_WIDTH; w++ ) {
			
			for ( int h = 0; h <= MAP_HEIGHT; h++ ) {
				
				mapIntArray[w][h] = TILE_WALL;
				
			}
			
		}
		
		
		//Generate starting room
		int startRoomX = (randomNumGen.nextInt((MAP_WIDTH / 2)) + ((MAP_WIDTH / 2) / 2));
		int startRoomY = (randomNumGen.nextInt((MAP_WIDTH / 2)) + ((MAP_WIDTH / 2) / 2));
		
		int startRoomWidth = randomNumGen.nextInt(20) + 5;
		int startRoomHeight = randomNumGen.nextInt(10) + 5;
		
		for ( int e = 0; e <= MAP_WIDTH; e++ ) {
			for ( int t = 0; t <= MAP_HEIGHT; t++ ) {
				
				mapSeenArray[e][t] = 100;
				
			}
		}
		
		for ( int w = 0; w < startRoomWidth; w++ ) {
			
			for ( int h = 0; h < startRoomHeight; h++ ) {
				
				mapIntArray[startRoomX + w][startRoomY + h] = TILE_BLANK;
				
			}
			
		}
		
		//Put player there
		practiceMap.setWindowX((startRoomX + (startRoomWidth / 2)) - playerCharacter.getX());
		practiceMap.setWindowY((startRoomY + (startRoomHeight / 2)) - playerCharacter.getY());
		
		
		int failedGens = 0;
		
		while (failedGens < 10) {
			
			failedGens ++;
			
					
		
			int pathDir = randomNumGen.nextInt(4);
			int hallSize = randomNumGen.nextInt(14) + 3;
			int hallStartX = 0;
			int hallStartY = 0;
			int hallDirX = 0;
			int hallDirY = 0;
			int hallEntranceOffset = 0;
			boolean doIt = false;
			
			switch (pathDir) {
			
				case DIR_NORTH:
					
					hallEntranceOffset = randomNumGen.nextInt(startRoomWidth - 1) + 1;
					
					hallStartX = startRoomX + hallEntranceOffset;
					hallStartY = startRoomY;
					hallDirX = 0;
					hallDirY = -1;
						
					if (mapIntArray[hallStartX][hallStartY] != TILE_WALL) {
						
						doIt = true;
							
					}	
					
				break;
				
				case DIR_EAST:
					
					hallEntranceOffset = randomNumGen.nextInt(startRoomHeight - 1) + 1;
					
					hallStartX = startRoomX + startRoomWidth - 1;
					hallStartY = startRoomY + hallEntranceOffset;
					hallDirX = 1;
					hallDirY = 0;
					
					if (mapIntArray[hallStartX][hallStartY] != TILE_WALL) {
						
						doIt = true;
								
					}
					
				break;
				
				case DIR_SOUTH:
					
					hallEntranceOffset = randomNumGen.nextInt(startRoomWidth - 1) + 1;
					
					hallStartX = startRoomX + hallEntranceOffset;
					hallStartY = startRoomY + startRoomHeight - 1;
					hallDirX = 0;
					hallDirY = 1;
					
					if (mapIntArray[hallStartX][hallStartY] != TILE_WALL) {
						
						doIt = true;
								
					}
					
				break;
				
				case DIR_WEST:
					
					hallEntranceOffset = randomNumGen.nextInt(startRoomHeight - 1) + 1;
					
					hallStartX = startRoomX;
					hallStartY = startRoomY + hallEntranceOffset;
					hallDirX = -1;
					hallDirY = 0;
					
					if (mapIntArray[hallStartX][hallStartY] != TILE_WALL) {
						
						doIt = true;
								
					}
					
				break;
			}
			
			if (doIt) {
			
				mapIntArray[hallStartX][hallStartY] = TILE_BLANK;
				
				int xOffset = 0;
				int yOffset = 0;
				
				for ( int i = 1; i <= hallSize; i++ ) {
					
					xOffset += hallDirX;
					yOffset += hallDirY;
					
					mapIntArray[hallStartX + xOffset][hallStartY + yOffset] = TILE_BLANK;
		
				}
			
			}
			
		}
		
		
		//practiceMap.getPracticeNPCs().add(new PracticeNPC("O", 10, 11, 100, "Orc", CSIColor.AQUA, 1, 0));
		//practiceMap.getPracticeNPCs().add(new PracticeNPC("O", 11, 11, 100, "Orc", CSIColor.AQUA, 1, 0));
		//practiceMap.getPracticeNPCs().add(new PracticeNPC("O", 12, 12, 100, "Orc", CSIColor.AQUA, 1, 0));
		//practiceMap.getPracticeNPCs().add(new PracticeNPC("O", 13, 13, 100, "Orc", CSIColor.AQUA, 1, 0));

		//practiceMap.getPracticeNPCs().add(new PracticeNPC("@", 13, 13, 5, "Jermaine", CSIColor.PALE_MAGENTA, 1, 0));
		
		
		practiceMap.setMapIntArray(mapIntArray);
		practiceMap.setMapSeenArray(mapSeenArray);
		
    	
		
		return practiceMap;
		
	}
	
	
	public PracticeMap randomWalkGen(int mapId) {
		PracticeMap practiceMap = new PracticeMap(practiceRougeLike);
		
		int[][] mapSeenArray = new int[MAP_WIDTH + 1][MAP_HEIGHT + 1];
		int[][] mapIntArray = new int[MAP_WIDTH + 1][MAP_HEIGHT + 1];
			
		
		
		
		//Map Generator 
		//Fill with Wall
		for ( int w = 0; w <= MAP_WIDTH; w++ ) {
			
			for ( int h = 0; h <= MAP_HEIGHT; h++ ) {
				
				mapIntArray[w][h] = TILE_WALL;
				
			}
			
		}
		
		
		//Generate starting room
		int lastX = (randomNumGen.nextInt((MAP_WIDTH / 2)) + ((MAP_WIDTH / 2) / 2));
		int lastY = (randomNumGen.nextInt((MAP_WIDTH / 2)) + ((MAP_WIDTH / 2) / 2));
				
		
		//Put player there
		practiceMap.setWindowX((lastX) - playerCharacter.getX());
		practiceMap.setWindowY((lastY) - playerCharacter.getY());
		
		mapIntArray[lastX][lastY] = PracticeMap.TILE_BLANK;
		
		//random walk gen algo
		
		int failedGens = 0;
		int genThreshold = 100;
		
		while (failedGens < genThreshold) {
			
					
			int digX = 0;
			int digY = 0;
			
			int pathDir = randomNumGen.nextInt(4);
			
					
			switch (pathDir) {
			
				case DIR_NORTH:
					
					digX = 0;
					digY = -1;
								
				break;
				
				case DIR_EAST:
					
					digX = 1;
					digY = 0;
					
				break;
				
				case DIR_SOUTH:
					
					digX = 0;
					digY = 1;
					
				break;
				
				case DIR_WEST:
					
					digX = -1;
					digY = 0;
					
				break;
			}
		
		
		
			if (lastX + digX > 2 && lastX + digX < MAP_WIDTH -1) {
				
				if (lastY + digY > 2 && lastY + digY < MAP_HEIGHT-1) {
					
					
				
								
					if (practiceMap.getMapArrayItem(lastX + digX, lastY + digY) != PracticeMap.TILE_WALL) {
						
						mapIntArray[lastX][lastY] = PracticeMap.TILE_BLANK;
						lastX = lastX + digX;
						lastY = lastY + digY;
						
					} else {
						
						failedGens ++;
						
					}
				
				} else {
					
					failedGens ++;
					
				}
				
			} else {
				
				failedGens ++;
					
			}
		
			
			
		
		
		}
		
		
		//randomly place NPCs
		
			int npcsRan = randomNumGen.nextInt(1000) + 1;
			
			
			int failedIterate = 0;
			int iterateThreshold = 100;
			
			int NPCCount = 0;
			
			while ( failedIterate < iterateThreshold || NPCCount < npcsRan) {
				
				int placeNPCX = randomNumGen.nextInt(MAP_WIDTH);
				int placeNPCY = randomNumGen.nextInt(MAP_HEIGHT);	
				
				
				if (mapIntArray[placeNPCX][placeNPCY] == PracticeMap.TILE_BLANK) {
					
					int chooseNPC = randomNumGen.nextInt(2);
					
					switch(chooseNPC) {
						
						case 0:
							practiceMap.getPracticeNPCs().add(new PracticeNPC("O", placeNPCX, placeNPCY, 100, "Orc", CSIColor.AQUA, 1, 0));
							NPCCount ++;
							break;
						
						case 1:
							practiceMap.getPracticeNPCs().add(new PracticeNPC("@", placeNPCX, placeNPCY, 5, "Jermaine", CSIColor.PALE_MAGENTA, 1, 0));
							NPCCount++;
							break;
						
					}
					
				} else {
					
					
					failedIterate ++;
					
				}
			
				
			}
			
			
			practiceMap.setNumNPCs(NPCCount);
				
			
		
		
		
		practiceMap.setMapIntArray(mapIntArray);
		practiceMap.setMapSeenArray(mapSeenArray);
		
    	
		
		return practiceMap;
		
	}
	
	

	public PracticeMap genStartMap(int mapId) {
		PracticeMap practiceMap = new PracticeMap(practiceRougeLike);
		
		int[][] mapSeenArray = new int[MAP_WIDTH + 1][MAP_HEIGHT + 1];
		int[][] mapIntArray = new int[MAP_WIDTH + 1][MAP_HEIGHT + 1];
			
		for ( int e = 0; e <= MAP_WIDTH; e++ ) {
			for ( int t = 0; t <= MAP_HEIGHT; t++ ) {
				
				mapSeenArray[e][t] = 100;
				
			}
		}
		
	
		for(int w = 0; w <= MAP_WIDTH; w++) {
			
			for(int h = 0; h <= MAP_HEIGHT; h++) {
				
				if ((w == 0) || (w == (MAP_WIDTH))) {
					
					mapIntArray[w][h] = 1;
					
				} else if ((h == 0) || (h == (MAP_HEIGHT))) {
					
					
					mapIntArray[w][h] = 1;
					
				} else {
					
					
					if ((w == 1) && (h == 1)) {
						
						mapIntArray[w][h] = 4;

					} else {
						
						mapIntArray[w][h] = 0;
						
					}
					
				}
				
			}
				
		}
		
		practiceMap.setMapIntArray(mapIntArray);
		practiceMap.setMapSeenArray(mapSeenArray);
		
    	
		//practiceMap.getPracticeNPCs().add(new PracticeNPC("O", 10, 11, 100, "Orc", CSIColor.AQUA, 1, 0));
		//practiceMap.getPracticeNPCs().add(new PracticeNPC("O", 11, 11, 100, "Orc", CSIColor.AQUA, 1, 0));
		//practiceMap.getPracticeNPCs().add(new PracticeNPC("O", 12, 12, 100, "Orc", CSIColor.AQUA, 1, 0));
		//practiceMap.getPracticeNPCs().add(new PracticeNPC("O", 13, 13, 100, "Orc", CSIColor.AQUA, 1, 0));

		practiceMap.getPracticeNPCs().add(new PracticeNPC("@", 13, 13, 5, "Jermaine", CSIColor.PALE_MAGENTA, 1, 0));
		
		playerCharacter.setX(25);
		playerCharacter.setY(10);
		
		return practiceMap;
		
	}
	

	
}
