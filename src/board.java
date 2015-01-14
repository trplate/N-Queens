import java.util.Random;



public class board {
	//Creates an array that acts as the board object.
	String[][] board = new String[8][8];
	int fitness = 0;
	
	void populateBoard(){
		    
			for(int i = 0; i < 8; i ++){
				for(int j = 0; j < 8; j ++){
					board[i][j] = "O";
			
				}
		
			}
			
	}
	
	void addQueens(){
		for (int i = 0; i < board.length; i++) {
			int randomSpot = randInt(0, 7);
			queenMaker.placeQueen(board, i, randomSpot);
		}
		
		
	}
	//prints a board to standard output with lines in between all the squares.
	String printBoard(){
		String finboard = "-------------------------------------\n";
		for(int i = 0; i < 8; i ++){
			finboard += "[ | ";
		    for(int j = 0; j < 8; j ++){
		    	
		    	finboard += board[i][j] + " | ";
		    	
		    }
		    finboard += "]\n" + "-------------------------------------\n";
		}
		return finboard;
		
	}
	
	
	
	
	
	
	
	
	//method that creates a random int, which is used a lot
	public int randInt(int min, int max) {

	    Random rand = new Random();
	    
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	
	//calculates how many queens are attacking other queens
	void getFitness(){
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				
				if(board[i][j] == "Q"){
					
					for (int spotX = 0; spotX < board.length; spotX++) {
						
						if(spotX == i){
							
							continue;
						}
						else if(board[spotX][j] == "Q"){
						
							fitness ++;
							
						}
					}
					int newX = i;
					int newY = j;
					for (int i2 = 0; i2 < board.length; i2++) {
						
						newX = newX - 1;
						newY = newY - 1;
						if(newX < 0 || newY < 0 ){
							
							break;
						}
						else if(board[newX][newY] == "Q"){
							
							fitness ++;
						}
					}
					newX = i;
					newY = j;
					for (int i3 = 0; i3 < board.length; i3++) {
						
						newX = newX + 1;
						newY = newY + 1;
						if(newX >= board.length || newY >= board.length ){
							
							break;
						}
						else if(board[newX][newY] == "Q"){
							
							fitness ++;
							
						}
					}
					newX = i;
					newY = j;
					for (int i4 = 0; i4 < board.length; i4++) {
						
						newX = newX - 1;
						newY = newY + 1;
						if(newX < 0 || newY >= board.length ){
							
							break;
						}
						else if(board[newX][newY] == "Q"){
							
							fitness ++;
							
						}
					}
					newX = i;
					newY = j;
					for (int i5 = 0; i5 < board.length; i5++) {
						
						newX = newX + 1;
						newY = newY - 1;
						if(newX >= board.length || newY < 0 ){
							
							break;
						}
						else if(board[newX][newY] == "Q"){
							
							fitness ++;
							
						}
					}
					
				}
				
			}
			
			
		}
		//Because each pair of attacking queens is counted twice, this gets the actual fitness number
		fitness = fitness / 2;
		
		
	}
	
	
	
	
	
	
	
}
