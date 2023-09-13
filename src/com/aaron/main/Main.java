package com.aaron.main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	
	    	int[][] original = { {7, 9}, {7, 10}, {7, 11}, {7, 12} };
	    	ArrayList<int[]> deadAdjacentNotChecked = new ArrayList<int[]>();
	    	String newMatrix = "";
	    	System.out.println("helloooooooooooooooooo");
	    	
	    	// for each alive cell, we first check the number of alive-neighbouring cells, effectively determining each alive-cell's fate
	    	// in summary, we first determine the fate of each alive cell, survivors will be added to the output string
	    	
	    	
	    	for (int x = 0; x < original.length; x++) {
	    		
	    		int xCoor = original[x][0];
	    		int yCoor = original[x][1];
	    		int aliveNeighbours = 0;
	    		
	    		int[] targetCoor = {xCoor, yCoor}; 	
	    		int[] surroundingCoor1 = {xCoor, yCoor - 1};
	    		int[] surroundingCoor2 = {xCoor, yCoor + 1};
	    		int[] surroundingCoor3 = {xCoor - 1, yCoor - 1};
	    		int[] surroundingCoor4 = {xCoor - 1, yCoor};
	    		int[] surroundingCoor5 = {xCoor - 1, yCoor + 1};
	    		int[] surroundingCoor6 = {xCoor + 1, yCoor - 1};
	    		int[] surroundingCoor7 = {xCoor + 1, yCoor};
	    		int[] surroundingCoor8 = {xCoor + 1, yCoor + 1};
	    		
	    		for (int i = 0; i < 8; i++) {
	    			
	    			if (i==0) {
	    				if (checkAgainstAliveList(original, surroundingCoor1)) {
	    					aliveNeighbours += 1;
	    				} else if (checkAgainstDeadList(deadAdjacentNotChecked, surroundingCoor1) == false) {
	    					deadAdjacentNotChecked.add(surroundingCoor1);
	    				}
	    			}
	    			if (i==1) {
	    				if (checkAgainstAliveList(original, surroundingCoor2)) {
	    					aliveNeighbours += 1;
	    				} else if (checkAgainstDeadList(deadAdjacentNotChecked, surroundingCoor2) == false) {
	    					deadAdjacentNotChecked.add(surroundingCoor2);
	    				}
	    			}
	    			if (i==2) {
	    				if (checkAgainstAliveList(original, surroundingCoor3)) {
	    					aliveNeighbours += 1;
	    				} else if (checkAgainstDeadList(deadAdjacentNotChecked, surroundingCoor3) == false) {
	    					deadAdjacentNotChecked.add(surroundingCoor3);
	    				}
	    			}
	    			if (i==3) {
	    				if (checkAgainstAliveList(original, surroundingCoor4)) {
	    					aliveNeighbours += 1;
	    				} else if (checkAgainstDeadList(deadAdjacentNotChecked, surroundingCoor4) == false) {
	    					deadAdjacentNotChecked.add(surroundingCoor4);
	    				}
	    			}
	    			if (i==4) {
	    				if (checkAgainstAliveList(original, surroundingCoor5)) {
	    					aliveNeighbours += 1;
	    				} else if (checkAgainstDeadList(deadAdjacentNotChecked, surroundingCoor5) == false) {
	    					deadAdjacentNotChecked.add(surroundingCoor5);
	    				}
	    			}
	    			if (i==5) {
	    				if (checkAgainstAliveList(original, surroundingCoor6)) {
	    					aliveNeighbours += 1;
	    				} else if (checkAgainstDeadList(deadAdjacentNotChecked, surroundingCoor6) == false) {
	    					deadAdjacentNotChecked.add(surroundingCoor6);
	    				}
	    			}
	    			if (i==6) {
	    				if (checkAgainstAliveList(original, surroundingCoor7)) {
	    					aliveNeighbours += 1;
	    				} else if (checkAgainstDeadList(deadAdjacentNotChecked, surroundingCoor7) == false) {
	    					deadAdjacentNotChecked.add(surroundingCoor7);
	    				}
	    			}
	    			if (i==7) {
	    				if (checkAgainstAliveList(original, surroundingCoor8)) {
	    					aliveNeighbours += 1;
	    				} else if (checkAgainstDeadList(deadAdjacentNotChecked, surroundingCoor8) == false) {
	    					deadAdjacentNotChecked.add(surroundingCoor8);
	    				}
	    			}
	    			
	    		}

	    		// end of inner loop that counts alive-surrounding cells of a single given alive cell
	    		// now that we have the number of alive-neighbouring cells for the given alive cell, we 
	    		// decide whether or not to add that cell to the new Matrix
	    		
	    		if (aliveNeighbours == 2 || aliveNeighbours == 3) {
	    			newMatrix = newMatrix + String.valueOf(targetCoor[0]) + "," + String.valueOf(targetCoor[1] + ":");
	    
	    		}
	    	
	    		// moves onto the next alive cell in the list given, to count number of neighbouring alive cells
	    		// back to the top of this 'for' loop
	    		
	    	}	
	    	
	    	System.out.println(newMatrix);
	    	System.out.println(deadAdjacentNotChecked.toString());
	    	System.out.println(deadAdjacentNotChecked.get(0)[0]);
	    	System.out.println(deadAdjacentNotChecked.get(0)[1]);
	    	
	    	//finished determining the fate of all alive cells provided
	    	// finished adding the ones that will make it to the new matrix string
	    	// now to go through the list of dead cells that neighbour at least one alive cell
	    	// in other words, whilst we wwere counting the number of neighbouring alive cells for a given alive cell, 
	    	// we were also taking note of neighbouring dead cells that will need to be checked for their survival due to 
	    	// having at least one neghbouring alive cell, I call these "relevant" dead cells, I was keeping a track of relevant dead cells 
	    	// as I was counting the number of alive cells for a given alive cell.
	    	// Also note that the relevant-dead-cell list was watching out for duplicates, as some alive cells may share one or more dead cells
	    	
	    	
	    	// now I go through the list or "relevant" dead cells and determine whether they will come alive
	    	// those that do will be added to the new matrix string
	    	// then we are done
	    	
	    	for (int p = 0; p < deadAdjacentNotChecked.size(); p++) {
	    		
	    		int xCoorD = deadAdjacentNotChecked.get(p)[0];
	    		int yCoorD = deadAdjacentNotChecked.get(p)[1];
	    		int aliveNeighboursD = 0;
	    		
	    		int[] targetCoorD = {xCoorD, yCoorD}; 	
	    		int[] surroundingCoor1D = {xCoorD, yCoorD - 1};
	    		int[] surroundingCoor2D = {xCoorD, yCoorD + 1};
	    		int[] surroundingCoor3D = {xCoorD - 1, yCoorD - 1};
	    		int[] surroundingCoor4D = {xCoorD - 1, yCoorD};
	    		int[] surroundingCoor5D = {xCoorD - 1, yCoorD + 1};
	    		int[] surroundingCoor6D = {xCoorD + 1, yCoorD - 1};
	    		int[] surroundingCoor7D = {xCoorD + 1, yCoorD};
	    		int[] surroundingCoor8D = {xCoorD + 1, yCoorD + 1};
	    		
	    		for (int j = 0; j < 8; j++) {
	    			
	    			if (j==0) {
	    				if (checkAgainstAliveList(original, surroundingCoor1D)) {
	    					aliveNeighboursD += 1;
	    				}
	    			}
	    			if (j==1) {
	    				if (checkAgainstAliveList(original, surroundingCoor2D)) {
	    					aliveNeighboursD += 1;
	    				} 
	    			}
	    			if (j==2) {
	    				if (checkAgainstAliveList(original, surroundingCoor3D)) {
	    					aliveNeighboursD += 1;
	    				} 
	    			}
	    			if (j==3) {
	    				if (checkAgainstAliveList(original, surroundingCoor4D)) {
	    					aliveNeighboursD += 1;
	    				} 
	    			}
	    			if (j==4) {
	    				if (checkAgainstAliveList(original, surroundingCoor5D)) {
	    					aliveNeighboursD += 1;
	    				}
	    			}
	    			if (j==5) {
	    				if (checkAgainstAliveList(original, surroundingCoor6D)) {
	    					aliveNeighboursD += 1;
	    				}
	    			}
	    			if (j==6) {
	    				if (checkAgainstAliveList(original, surroundingCoor7D)) {
	    					aliveNeighboursD += 1;
	    				} 
	    			}
	    			if (j==7) {
	    				if (checkAgainstAliveList(original, surroundingCoor8D)) {
	    					aliveNeighboursD += 1;
	    				}
	    			}
	    			
	    		}

	    		// end of inner loop that counts alive-surrounding cells of a relevant dead cell
	    		
	    		if (aliveNeighboursD == 3) {
	    			newMatrix = newMatrix + String.valueOf(targetCoorD[0]) + "," + String.valueOf(targetCoorD[1] + ":");
	    		}
	    	
	    		// moves onto the next relevant dead cell to count number of neighbouring alive cells
	    		
	    	}
	    	
	    	
	    	// now we have determined the fate of alive cells and also the fate of all relevant and adjacent dead cells
	    	// PRINT RESULT
	    	System.out.println("THIS IS THE NEW MATRIX: " + newMatrix);
	    	
	    	
	    }
		
	
	
	public static boolean checkAgainstAliveList(int[][] aliveList, int[] subArray) {
    	
    	boolean yesOrNo = false;
    	
    	for (int a = 0; a < aliveList.length; a++) {
    		
    		if (subArray[0] == aliveList[a][0] && subArray[1] == aliveList[a][1]) {
    			yesOrNo = true;
    		} 
    		
    	}
    	
    	return yesOrNo;
    	
    }
    
    public static boolean checkAgainstDeadList(ArrayList<int[]> deadAdjacentNotChecked, int[] subArray) {
    	
    	boolean yesOrNo = false;
    	
    	if (deadAdjacentNotChecked.size() == 0) {
    		
    		yesOrNo = false;
    		
    	} else {
    	
	    	for (int k = 0; k < deadAdjacentNotChecked.size(); k++) {
	    		
	    		if (subArray[0] == deadAdjacentNotChecked.get(k)[0] && subArray[1] == deadAdjacentNotChecked.get(k)[1]) {
	    			yesOrNo = true;
	    		} 
	    		
	    	}
    	
    	}
    	
    	return yesOrNo;
    	
    }

	
}
