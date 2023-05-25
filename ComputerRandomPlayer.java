
public class ComputerRandomPlayer implements Player{
	int computerChoice;
	boolean alreadyPlayed;
	
	public void play(TicTacToeGame game) {
		if(!(game.getGameState()==GameState.PLAYING)){
			System.out.println();
		}else {
			computerChoice = Utils.generator.nextInt(game.lines*game.columns);
			System.out.println("Player 2's turn");
			
			alreadyPlayed=false;
		    while(computerChoice<game.lines*game.columns && alreadyPlayed==false) {
		    	if(game.valueAt(computerChoice)==CellValue.EMPTY) { 
		    		game.play(computerChoice);
		    		alreadyPlayed=true;
		    	}else {
		    		computerChoice=Utils.generator.nextInt(game.lines*game.columns);
		    	}
		    }
		
	}

}
}
