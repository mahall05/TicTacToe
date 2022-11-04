public class GameBoard{
    private Move[][] board;

    public GameBoard(int size){
        board = new Move[size][size];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = new Move(0);
            }
        }
    }

    public char detectWin(){
        boolean cont = false;

        // HORIZONTAL WIN
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length-1; j++){
                if(board[i][j].toString().equals(board[i][j+1].toString()) && !board[i][j].toString().equals(" ")){
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
                if(board[j][i].toString().equals(board[j+1][i].toString()) && !board[j][i].toString().equals(" ")){
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
            if(board[i][i].toString().equals(board[i+1][i+1].toString()) && !board[i][i].toString().equals(" ")){
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
            if(board[r][i].toString().equals(board[r+1][i-1].toString()) && !board[r][i].toString().equals(" ")){
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
        System.out.print("  ");
        for(int i = 1; i <= board.length; i++){
            System.out.print(" " + i + " ");
        }
        System.out.println();

        int c = 0;
        for(int i = 0; i < board.length; i++){
            c = i >= 26 ? 1 : 0;
            System.out.print((c == 0 ? (char) (i+97) : (char) (i+65)) + " ");

            for(int j = 0; j < board[i].length; j++){
                System.out.print("[" + board[i][j].toString() + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void moveAt(int r, int c, int player) throws ArrayIndexOutOfBoundsException{
        board[r][c] = new Move(player);
    }
}