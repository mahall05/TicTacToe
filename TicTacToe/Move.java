public class Move {
    private static char[] options = {' ', 'X', 'O'};
    private char m;

    public Move(int m){
        this.m = options[m];
    }

    public String toString(){
        if(m == 'X'){
            return (Color.RED + m + Color.RESET);
        }else if(m == 'O'){
            return (Color.GREEN + m + Color.RESET);
        }else{
            return (""+ m);
        }
    }

}
