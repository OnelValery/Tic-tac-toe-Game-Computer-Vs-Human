import java.util.Scanner;

public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters line  and column
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

   
        try{
            if (args.length >= 2) {
                lines = Integer.parseInt(args[0]);
                if(lines<2){
                    System.out.println("Invalid argument, using default...");
                    lines = 3;
                }
                columns = Integer.parseInt(args[1]);
                if(columns<2){
                    System.out.println("Invalid argument, using default...");
                    columns = 3;
                }
            }
            if (args.length >= 3){
                win = Integer.parseInt(args[2]);
                if(win<2){
                    System.out.println("Invalid argument, using default...");
                    win = 3;
                }
            } 
            if (args.length > 3){
                System.out.println("Too many arguments. Only the first 3 are used.");
            } 

        } catch(NumberFormatException e){
            System.out.println("Invalid argument, using default...");
            lines   = 3;
            columns  = 3;
            win = 3;
        }
        
        Player[] players;

        // YOUR CODE HERE  Scanner player;
        int iPlayFirst= Utils.generator.nextInt(2);
        
        players= new Player[2];
        game = new TicTacToeGame(lines, columns,win);
        
        if(iPlayFirst==0) {
       	 players[0]= new HumanPlayer();
       	 players[1]= new ComputerRandomPlayer();
       
        }else {
        players[0]= new ComputerRandomPlayer();
       	 players[1]= new HumanPlayer();
        }
        System.out.println("$ java TicTacToe");
        while(game.getGameState() == GameState.PLAYING) {
        	
            players[0].play(game);
            players[1].play(game);
            if (game.getGameState()!=GameState.PLAYING) {
            	System.out.println("Game Over");
                System.out.println(game);
                System.out.println("Result: " + game.getGameState());
                System.out.println("Play again (Y)?");
                Scanner answer;
                answer = new Scanner(System.in);
                
                if ((answer.nextLine().toUpperCase()).equals("Y") ) {
                	game = new TicTacToeGame(lines, columns,win);
                	System.out.println(game.getGameState());
            		}
                if(iPlayFirst==0) {
                	players[0]= new ComputerRandomPlayer();
                 	players[1]= new HumanPlayer();
                   }else {
                	   players[0]= new HumanPlayer();
                       players[1]= new ComputerRandomPlayer();
                }
                
        }
        
        }

     }

}