import java.util.*;

public class TicTacToe{
    public static void main(String[] args){
        ticTacToe();
    }
    private static void ticTacToe(){

        //TicTacToe board
        char[][] board = new char[3][3];

        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                board[i][j] = ' ';
            }
        }

        //for move
        Scanner scMove = new Scanner(System.in);

        boolean isOver = false;
        char player = 'X';

        while(!isOver){
            display(board);
            
            //if all the boxes are full and we can't find winner then no winner
            if(isFull(board)){
                System.out.println("this game has no winner !!");
                isOver =true;
            }
            else{

                System.out.print("Player " +player+" turn enter move: ");
                int r = scMove.nextInt();
                int c = scMove.nextInt();


                if(isValid(board,r,c)){

                    board[r][c] = player;

                    if(isWin(board,player,r,c)){
                        display(board);
                        System.out.println("Player "+player+" Won the game!!");
                        isOver = true;
                    }else{
                        if(player == 'O'){
                            player = 'X';
                        }else{
                            player = 'O';
                        }
                    }

                }else{
                    System.out.println("not valid move enter again");
                }
            }
        }
    }

    private static void display(char[][] board){
        for (char[] chars : board) {

            System.out.println("-------------");
            System.out.print("| ");

            for (char aChar : chars) {
                System.out.print(aChar + " | ");
            }
            System.out.println();
        }

        System.out.println("-------------");
    }

    private static boolean isFull(char[][] board){

        for(char[] ele: board){
            for(char e: ele){
                if(e == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board,int r,int c){
        return r >= 0 && r<3 && c >=0 && c<3 && board[r][c] == ' ';
    }

    private static boolean isWin(char[][] board,char ch,int r, int c){

        for(int row =0; row <3 ;row ++){

            boolean check = true;

            //for horizontal
            for(int col = 0; col < 3;col++){
                if(board[row][col] != ch){
                    check = false;
                    break;
                }
            }
            if(check){
                return true;
            }

            //for vertical
            check = true;

            for(int i = 0; i<3;i++){
                if(board[i][row] != ch){
                    check = false;
                    break;
                }
            }

            if(check){
                return true;
            }
        }

        if(board[0][2] == ch && board[1][1] == ch && board[2][0] == ch){
            return true;
        }
        return board[0][0] == ch && board[1][1] == ch && board[2][2] == ch;
    }

}
