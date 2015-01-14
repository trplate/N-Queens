import java.util.ArrayList;


public class MateAndMutate{
	//the two parents begin as null
	board specimen1 = null;
	board specimen2 = null;
	//this checks to see if two parents have been aquired by the getTwoSpecimen method
	int gotTwo = 0;
	
	//I'm still working on improving the probability in this but it works for now
	void getTwoSpecimen(ArrayList<board> boardCollection){
		//if two parents have already been placed in specimen1 and 2 then break from the loop
		for (board board : boardCollection) {
			if(gotTwo == 2){
				break;
			}
			//The most fit boards have the best chance of being picked
			if(board.fitness <= 2){
				int chance = board.randInt(1, 10);
				if(chance != 1){
					if(specimen1 == null){
						specimen1 = board;
						gotTwo ++;
					}
					else if(specimen1 != board){
						specimen2 = board;
						gotTwo ++;
					}
					
				}
			}
			else if(board.fitness <= 6){
				int chance = board.randInt(1, 10);
				if(chance > 3){
					if(specimen1 == null){
						specimen1 = board;
						gotTwo ++;
						}
						else if(specimen1 != board){
							specimen2 = board;
							gotTwo ++;
						}
				}
				
			}
			else if(board.fitness <= 10){
				int chance = board.randInt(1, 10);
				if(chance > 5){
					if(specimen1 == null){
						specimen1 = board;
						gotTwo ++;
						}
						else if(specimen1 != board){
							specimen2 = board;
							gotTwo ++;
						}
				}
				
			}
			else if(board.fitness <= 15){
				int chance = board.randInt(1, 10);
				if(chance > 7){
					if(specimen1 == null){
						specimen1 = board;
						gotTwo ++;
						}
						else if(specimen1 != board){
							specimen2 = board;
							gotTwo ++;
						}
				}
				
			}
			else{
				int chance = board.randInt(1, 10);
				if(chance > 9){
					if(specimen1 == null){
						specimen1 = board;
						gotTwo ++;
						}
						else if(specimen1 != board){
							specimen2 = board;
							gotTwo ++;
						}
				}
				
			}
			
		}
		//If there still aren't two parents, start over
		if(gotTwo < 2){
			getTwoSpecimen(boardCollection);
		}
		
	}
	
	
	//This takes two boards and makes a new board based on the first half of the first parent and the second half of the second parent
	board mate(board a, board b){
		board baby = new board();
		baby.populateBoard();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < a.board.length; j++) {
				
				if(a.board[i][j] == "Q"){
					
					baby.board[i][j] = "Q";
				
				}
			}
		}
		for (int i = 4; i < b.board.length; i++) {
			for (int j = 0; j < b.board.length; j++) {
				
				if(b.board[i][j] == "Q"){
					
					baby.board[i][j] = "Q";
				
				}
			}
		}
		return baby;
		
	}
	
	
	//This method goes through each of the board rows and has a 1 in a 100 chance of changing a queen location in that row.
	void mutate(board board){
		for (int i = 0; i < board.board.length; i++) {
			int badGene = board.randInt(0, 100);
			if(badGene == 7){
				
				for (int j = 0; j < board.board.length; j++) {
					if(board.board[i][j] == "Q"){
						board.board[i][j] = "O";
						
					}
					
				}
				int mixUp = board.randInt(0, 7);
				board.board[i][mixUp] = "Q";
				break;
				
			}
		}		
		
	}
	
	//this method makes a new arraylist of boards based on the parent population
	ArrayList<board> newPopulation(ArrayList<board> boardCollection, int sizeOfArrayList){
		
		ArrayList<board> newPop = new ArrayList<board>();
		//because two parents make two children apiece the number of times you need to run this loop is half the length of the parent array.
		int numberOfMates = sizeOfArrayList;
		for (int i = 0; i < numberOfMates; i++) {
			//get two parents and mate.
			getTwoSpecimen(boardCollection);
			board babyBoard = mate(specimen1, specimen2);
			//get the fitness of the new boards
			babyBoard.getFitness();
			board babyBoard2 = mate(specimen2, specimen1);
			babyBoard2.getFitness();
			//add the boards to the new arraylist
			newPop.add(babyBoard);
			newPop.add(babyBoard2);
			//make sure that before you run getTwoSpecimen again, you reset the variables.
			specimen1 = null;
			specimen2 = null;
			gotTwo = 0;
			
		}
		//for each new babyboard, run the mutate method.
		for (board board : newPop) {
			mutate(board);
		}
		return newPop;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
