package tictactoe;
import java.util.Scanner;

public class TicTacToe {
    Scanner sc = new Scanner(System.in);
    int row, column;
    int[][] play = new int[4][4];
    String Continue;
    public TicTacToe(){
        System.out.println("********** Game Start **********");
    }
    public void setPlay(boolean player){
        do{
            if (player)
                System.out.print("Player-O, enter your move (row[1-3],column[1-3]): ");
            else 
                System.out.print("Player-X, enter your move (row[1-3],column[1-3]): ");
            
                String input = sc.next();
            //判斷是否輸入正確規則
            if (!(input.matches("[1-3],[1-3]")) ){
                System.out.println("The value you entered is invalid! Please try again.");
                continue;}
            else {
                row = Character.getNumericValue(input.charAt(0));
                column = Character.getNumericValue(input.charAt(2));
                //判斷是否重複輸入
                if (play[row][column] != 0){
                    System.out.println("The value you entered is invalid! Please try again.");
                    continue;}
            }
            if (player){
                play[row][column] = 11;//O
                break;}
            else {
                play[row][column] = 12;//X
                break;}
        }while(true);
    }
   
    public void show(){
        for (int i = 1 ; i < play.length ; i++){
            System.out.println("\n-------------");
            for (int j = 1 ; j < play[i].length ; j++){
                switch (play[i][j]){
                    case 0 :System.out.print("   |"); break;
                    case 11 :System.out.print(" o |"); break;    
                    case 12 :System.out.print(" x |"); break;
                }
            }
        }
        System.out.println();
    }
    
    public boolean check(){
        int count = 0, count1 = 0;
        //橫
        for (int i = 1 ; i < play.length ; i++){
            for (int j = 1 ; j < play[i].length ; j++){
                switch (play[i][j]){
                    case 11 : count += 1; break;
                    case 12 : count1 += 1; break;
                }
            }
            if (count == 3) {
                System.out.println("Player-O is the winner!");
                return false;
            }
            else if (count1 == 3){
                System.out.println("Player-X is the winner!");
                return false;
            }
            count = 0;
            count1 = 0;
        }
        
            
        //直
        for (int i = 1 ; i < play.length ; i++){
            for (int j = 1 ; j < play[i].length ; j++){
                switch (play[j][i]){
                    case 11 : count += 1; break;
                    case 12 : count1 += 1; break;
                }
            }
            if (count == 3) {
                System.out.println("Player-O is the winner!");
                return false;
            }
            else if (count1 == 3){
                System.out.println("Player-X is the winner!");
                return false;
            }
            count = 0;
            count1 = 0;
        }
        //斜
        if ((play[1][1] + play[2][2] + play[3][3]) == 33 || (play[1][3] + play[2][2] + play[3][1]) == 33){
            System.out.println("Player-O is the winner!");
            return false;
        }
        else if ((play[1][1] + play[2][2] + play[3][3]) == 36 || (play[1][3] + play[2][2] + play[3][1]) == 36){
            System.out.println("Player-X is the winner!");
            return false;
        }
        for (int i = 1 ; i < play.length ; i++){
            for (int j = 1 ; j < play[i].length ; j++){
                if (play[i][j] == 0)
                   return true; 
            }
        }
        //滿盤
        System.out.println("It's a Draw!");
        return false;
    }
    
    public boolean getContinue(){
        do {
            System.out.println("******** 再玩一次(Y/N)? ********");
            Continue = sc.next();
            switch (Continue) {
                case "Y":
                    return true;
                case "N":
                    return false;
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("請輸入Y/N");
            }
        }while(true);
    }
    
    public void resetArray(){
        for (int i = 1 ; i < play.length ; i++){
            for (int j = 1 ; j < play[i].length ; j++){
                play[i][j] = 0;
            }    
        }
    }
}
    
    
    

    
