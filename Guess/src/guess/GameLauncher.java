package guess;
import java.util.Scanner;


public class GameLauncher {
    public static void main(String[] args) {
        Guess guess = new Guess();
        int times=0;
        do{ 
            guess.GuessStart();
            System.out.println("*********** 遊戲開始 ***********");
            System.out.printf("數字範圍: %d ~ %d\n",guess.getMin(),guess.getMax());
            
            for (int i = 1 ; i<= guess.getLimit() ; i++){
                try {
                    System.out.print("您猜的數字: ");
                    Scanner sc = new Scanner(System.in);
                    String input = sc.next();
                    
                    int num = Integer.parseInt(input);
                    
                    if (num > guess.getMax() || num < guess.getMin())
                        System.out.println("猜錯了! 您猜的數字超出答案範圍!");
                        
                    else if (num < guess.getRandom()){
                        guess.setNum(num);
                        System.out.println("猜錯了! 您猜的數字比答案小!");
                        }
                    else if (num > guess.getRandom()){
                        guess.setNum(num);
                        System.out.println("猜錯了! 您猜的數字比答案大!");
                        }
                    else if (num == guess.getRandom()){
                        guess.setNum(num);
                        System.out.println("恭喜您猜對了!");
                        break;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("請輸入數值");
            }
                
            }    
            guess.show();
            
        } while (guess.getContinue());
    
    }
}
