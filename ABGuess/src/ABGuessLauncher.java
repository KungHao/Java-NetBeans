
import java.util.Scanner;

public class ABGuessLauncher {
    public static void main(String[] args) {
        ABGuess ab = new ABGuess();
        do {
            int count = 0;
            System.out.println("********** 猜數字遊戲 **********");
            ab.SetNum();
            System.out.print("正確答案: ");
            ab.Show();
            System.out.println("\n*********** 遊戲開始 ***********");
            
            do{
                ab.A=0;
                System.out.print("請輸入您猜的數字: ");
                Scanner sc = new Scanner(System.in);
                String guess=sc.next();
                if (ab.Cheak(guess)){
                    continue;}
                ab.Site(guess);
                count +=1;
                
            }while(ab.A < 4);
            System.out.println("恭喜您答對了!");
            System.out.println("*********** 遊戲結束 ***********");
            System.out.printf("您總共猜了%d次!\n",count);
        }while(ab.getContinue());
    }
}
