public class GameBoard{
    public static String[] players = {" ", Color.RED+'X'+Color.RESET, Color.GREEN+'O'+Color.RESET};
    private String[][] board;

    public GameBoard(int size){
        board = new String[size][size];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = players[0];
            }
        }
    }

    public char detectWin(){
        boolean cont = false;

        // HORIZONTAL WIN
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length-1; j++){
                if(board[i][j].equals(board[i][j+1]) && !board[i][j].equals(" ")){
                    cont = true;
                }else{
                    cont = false;
                }
                j = cont ? j : board.length + 100;
            }

            i = cont ? board.length + 100 : i;
        }

        if (cont)
            return '-';


        // VERTICAL WIN
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length-1; j++){
                if(board[j][i].equals(board[j+1][i]) && !board[j][i].equals(" ")){
                    cont = true;
                }else{
                    cont = false;
                }
                j = cont ? j : board.length + 100;
            }

            i = cont ? board.length + 100 : i;
        }

        if(cont)
            return '|';

        // DIAG WIN (\)
        for(int i = 0; i < board.length-1; i++){
            if(board[i][i].equals(board[i+1][i+1]) && !board[i][i].equals(" ")){
                cont = true;
            }else{
                cont = false;
                i = board.length+100;
            }
        }

        if(cont)
            return '\\';

        // DIAG WIN (/)
        for(int i = board.length-1; i > 0; i--){
            int r = Math.abs(i-board.length+1);
            if(board[r][i].equals(board[r+1][i-1]) && !board[r][i].equals(" ")){
                cont = true;
            }else{
                cont = false;
                i = -10;
            }
        }

        if(cont)
            return '/';
        
        return ' ';
    }

    // Lowercase letter ranges: 97-122
    // Uppercase letter ranges: 65-90

    public void printBoard(){
        System.out.print("\n  ");
        for(int i = 1; i <= board.length; i++){
            if((""+i).length() > 1)
                System.out.print(i + " ");
            else
                System.out.print(" " + i + " ");
        }
        System.out.println();

        int c = 0;
        for(int i = 0; i < board.length; i++){
            c = i >= 26 ? 1 : 0;
            System.out.print((c == 0 ? (char) (i+97) : (char) (i+65)) + " ");

            for(int j = 0; j < board[i].length; j++){
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void moveAt(int r, int c, int player) throws PlaceAlreadyTakenException{
        if(board[r][c].equals(" ")){
            board[r][c] = players[player];
        }else{
            throw new PlaceAlreadyTakenException("This place is already taken");
        }
    }
}
