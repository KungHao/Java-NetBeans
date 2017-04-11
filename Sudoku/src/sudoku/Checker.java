package sudoku;

import java.util.Scanner;

public class Checker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sudoku sudoku = new Sudoku();
        String input;
        int[][] a = new int[10][10];
        
        for (int i = 1 ; i < a.length ; i++){
            for (int j = 1 ; j < a[i].length ; j++){
                input=sc.next();
                a[i][j] = Integer.parseInt(input);
            }
        }
        if (sudoku.check(a))
            System.out.println("True");
        else 
            System.out.println("False");
    }
}