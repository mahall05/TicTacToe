import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println(Color.GREEN+"\n\n****************************************\n");
        System.out.println(Color.GREEN+"Welcome to Tic-Tac-Toe!");
        System.out.print(Color.CYAN+"Choose gameboard size (max: 26) >> "+Color.RESET);

        int size = 0;
        while(size == 0){
            try{
                size = Integer.parseInt(getInput());
                if(size > 26 || size < 1){
                    size = 0;
                    System.out.print(Color.RED+"Size out of range, please try again (max: 26) >> "+Color.RESET);
                }
            }catch(NumberFormatException e){
                System.out.println(Color.RED+"Invalid entry, please enter a number only >> "+Color.RESET);
            }
        }

        GameBoard board = new GameBoard(size);

        int player = 0;
        while(board.detectWin() == ' '){
            board.printBoard();
            
            try{
                move(board, player+1);
                player = Math.abs(player-1);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(Color.RED+"Invalid input, try again"+Color.RESET);
            }catch(NumberFormatException e){
                System.out.println(Color.RED+"Please enter the row before the column (i.e. a2)"+Color.RESET);
            }catch(PlaceAlreadyTakenException e){
                System.out.println(Color.RED+"This place is already taken, please choose another"+Color.RESET);
            }catch(StringIndexOutOfBoundsException e){
                System.out.println(Color.RED+"Invalid input, try again"+Color.RESET);
            }
        }

        board.printBoard();
        System.out.println(((Math.abs(player-1)+1) == 1 ? Color.RED : Color.GREEN) + "Player " + (Math.abs(player-1)+1) + " wins " + (board.detectWin()=='-'?"horizontally (-)":(board.detectWin()=='|'?"vertically (|)":(board.detectWin()=='\\'?"diagonally (\\)":(board.detectWin()=='/'?"diagonally (/)":"somehow..."))))+Color.RESET);
    }

    private static void move(GameBoard board, int player) throws PlaceAlreadyTakenException{
        System.out.print((player == 1 ? Color.RED : Color.GREEN) + "Player " + player + Color.RESET + " ("+GameBoard.players[player]+")" + Color.CYAN + " Enter a space >> "+Color.RESET);
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
