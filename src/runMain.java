import java.util.ArrayList;


public class runMain {
	static int rawAverage = 0;
	//Just a main class for testing
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			
		board newBoard1 = new board();
		newBoard1.populateBoard();
		newBoard1.addQueens();
		board newBoard2 = new board();
		newBoard2.populateBoard();
		newBoard2.addQueens();
		board newBoard3 = new board();
		newBoard3.populateBoard();
		newBoard3.addQueens();
		board newBoard4 = new board();
		newBoard4.populateBoard();
		newBoard4.addQueens();
		board newBoard5 = new board();
		newBoard5.populateBoard();
		newBoard5.addQueens();
		board newBoard6 = new board();
		newBoard6.populateBoard();
		newBoard6.addQueens();
		board newBoard7 = new board();
		newBoard7.populateBoard();
		newBoard7.addQueens();
		board newBoard8 = new board();
		newBoard8.populateBoard();
		newBoard8.addQueens();
		board newBoard9 = new board();
		newBoard9.populateBoard();
		newBoard9.addQueens();
		board newBoard10 = new board();
		newBoard10.populateBoard();
		newBoard10.addQueens();
		
		ArrayList<board> boardCollection = new ArrayList<board>();
		boardCollection.add(newBoard1);
		boardCollection.add(newBoard2);
		boardCollection.add(newBoard3);
		boardCollection.add(newBoard4);
		boardCollection.add(newBoard5);
		boardCollection.add(newBoard6);
		boardCollection.add(newBoard7);
		boardCollection.add(newBoard8);
		boardCollection.add(newBoard9);
		boardCollection.add(newBoard10);
		for (board board : boardCollection) {
			board.getFitness();
		}
		int counter = 0;
		boolean match = false;
		while(match == false){
			System.out.println(counter);
			MateAndMutate world = new MateAndMutate();
			ArrayList<board> newBoardCollection = world.newPopulation(boardCollection, boardCollection.size());
			for (board board : newBoardCollection) {
				if(board.fitness == 0){
					System.out.println(board.printBoard());
					System.out.println(board.fitness);
					match = true;
					break;
				}
			}
			boardCollection = newBoardCollection;
			counter ++;
			
			
			
		}
		rawAverage += counter;
		
		}
		int Average = rawAverage / 100;
		System.out.println(Average);
		//enviroment(boardCollection);
		
	}
	
	/*static void enviroment(ArrayList<board> boardCollection){
		MateAndMutate world = new MateAndMutate();
		ArrayList<board> newBoardCollection = world.newPopulation(boardCollection, boardCollection.size());
		for (board board : newBoardCollection) {
			if(board.fitness == 0){
				System.out.println(board.printBoard());
				System.out.println(board.fitness);
				return;
			}
		}
		System.out.println(counter);
		counter ++;
		enviroment(newBoardCollection);
		
	}*/

}
