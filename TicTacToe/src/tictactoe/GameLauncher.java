package tictactoe;

import java.util.Scanner;

public class GameLauncher {
    
    public static void main(String[] args) {
        TicTacToe tic = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        do{
            tic.resetArray();//將陣列歸零
            do { 
                tic.setPlay(false);//X先手
                tic.show();
                if (!(tic.check())) break;
                tic.setPlay(true);//換O
                tic.show();
            }while (tic.check());
        }while(tic.getContinue());
    }
    
}
