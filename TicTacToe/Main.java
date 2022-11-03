import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        GameBoard board = new GameBoard(3);
        board.printBoard();

        int player = 0;
        while(!board.detectWin()){
            System.out.println("Player " + (player+1) + ":");
            board.printBoard();
            
            try{
                move(board, player+1);
                player = Math.abs(player-1);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid input, try again");
            }
        }
    }

    private static void move(GameBoard board, int player) throws ArrayIndexOutOfBoundsException{
        String input = getInput();
        int row = parseRow(input);
        int column = Integer.parseInt(input.substring(1))-1;

        board.moveAt(row, column, player);
    }

    private static String getInput(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        return input;
    }

    private static int parseRow(String in){
        char c = in.charAt(0);
        int n;

        if(((int) c) - 97 < 0){
            n = ((int) c) - 65;
        }else{
            n = ((int ) c ) - 97;
        }

        return n;
    }
}
