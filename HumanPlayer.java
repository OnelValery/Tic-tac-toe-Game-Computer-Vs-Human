import java.util.Scanner;
public class HumanPlayer implements Player {
	Scanner humanPlayer;
	int humanPlayerChoice;
	TicTacToe tictac;
	boolean playMove;
	
	public HumanPlayer() {
		
		
	}
	
	public void play(TicTacToeGame game) {
		if(!(game.getGameState()==GameState.PLAYING)){
		 System.out.println();
		}else {
			System.out.println("Player 1's turn");
			System.out.println(game);
			System.out.print(game.nextCellValue() + " to play: ");
			humanPlayer = new Scanner(System.in);
			humanPlayerChoice= humanPlayer.nextInt()-1;
			
			playMove=true;
			while(playMove==true)
				
				if(humanPlayerChoice < 0 || humanPlayerChoice >= (game.lines*game.columns)){
						System.out.println("The value should be between 1 and " + (game.lines*game.columns));
						System.out.println(game);
						System.out.print(game.nextCellValue() + " to play: ");
						humanPlayer = new Scanner(System.in);
						humanPlayerChoice= humanPlayer.nextInt()-1;
						
					} else if(game.valueAt(humanPlayerChoice) != CellValue.EMPTY) {
						System.out.println("This cell has already been played");
						System.out.println(game);
						System.out.print(game.nextCellValue() + " to play: ");
						humanPlayer = new Scanner(System.in);
						humanPlayerChoice= humanPlayer.nextInt()-1;
					} else {
						game.play(humanPlayerChoice);
						playMove=false;
					}
			
			
			
		}
		

	}

}
