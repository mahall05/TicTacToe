import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("******************************");
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.print("Choose gameboard size >> ");
        int size = 0;
        while(size == 0){
            try{
                size = Integer.parseInt(getInput());
            }catch(NumberFormatException e){
                System.out.println("Invalid entry, please enter a number only");
            }
        }

        GameBoard board = new GameBoard(size);
        board.printBoard();

        int player = 0;
        while(board.detectWin() == ' '){
            System.out.println("Player " + (player+1) + ":");
            board.printBoard();
            
            try{
                move(board, player+1);
                player = Math.abs(player-1);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid input, try again");
            }catch(NumberFormatException e){
                System.out.println("Please enter the row before the column (i.e. a2)");
            }catch(PlaceAlreadyTakenException e){
                System.out.println("This place is already taken, please choose another");
            }catch(StringIndexOutOfBoundsException e){
                System.out.println("Invalid input, try again");
            }
        }

        board.printBoard();
        System.out.println("Player " + (Math.abs(player-1)+1) + " wins " + (board.detectWin()=='-'?"horizontally (-)":(board.detectWin()=='|'?"vertically (|)":(board.detectWin()=='\\'?"diagonally (\\)":(board.detectWin()=='/'?"diagonally (/)":"somehow...")))));
    }

    private static void move(GameBoard board, int player) throws PlaceAlreadyTakenException{
        System.out.print("Enter a space >> ");
        String input = getInput();
        int row = parseRow(input);
        int column = Integer.parseInt(input.substring(1))-1;

        board.moveAt(row, column, player);
    }

    private static String getInput(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        //in.close();
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
