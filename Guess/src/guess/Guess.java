package guess;

import java.util.Scanner;

public class Guess {
    int max, min, limit, ran, x;
    String Continue;
    int[] num;
    Scanner sc = new Scanner(System.in);
    public void GuessStart(){
        System.out.println("********** 猜數字遊戲 **********");
        System.out.print("猜數字範圍最小值: ");
        min = sc.nextInt();
        x = 1 ;
        do{ 
        System.out.print("猜數字範圍最大值: ");
        max = sc.nextInt();
        if (max <= min)
            System.out.println("最大值必須比最小值大\n");
        else
            break;
        }while(true);
        
        System.out.print("猜數字次數限制: ");
        limit = sc.nextInt();
        ran = (int) (Math.random() * (max - min + 1) + min);
        num = new int[limit+1];
        for (int j = 1 ; j<num.length ; j++){
            num[j] = 0;
        }
    }
    public int getMax(){
        return max;
    }
    public int getMin(){
        return min;
    }
    public int getLimit(){
        return limit;
    }
    public int getRandom(){
        return ran;
    }
    public void setNum(int num){
        this.num[x]=num;
        x += 1 ;
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
    public void show(){
        System.out.println("*********** 遊戲結束 ***********");
        for (int i = 1 ; i < x ; i++){
            System.out.printf("第%d猜: %d\n", i, num[i]);
        }
        System.out.println("---");
        System.out.printf("猜數字限制%d次\n",limit);
        System.out.printf("您總共猜了%d次\n", x-1);
        System.out.printf("正確答案: %d\n", ran);
    }
}
