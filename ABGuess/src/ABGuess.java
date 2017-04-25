
import java.util.Scanner;

public class ABGuess {
    Scanner sc = new Scanner(System.in);
    int[] num;
    String[] ab;
    String Continue;
    int A, B;
    public void SetNum(){
        num = new int[10];
        ab = new String[5];
        for (int i = 0 ; i<10;i++){
            num[i]=i;
        }   
        int c = 1;
        do{
            int ran = (int)(Math.random()* 10 + 0);
            if (num[ran] != 0){
                ab[c]=String.valueOf(num[ran]);
                c +=1;
                num[ran]=0;
            }
        }while(c<=4);    
    }
    
    public void Show(){
        for (int i = 1 ; i < ab.length ; i++)
        System.out.print(ab[i]);
    }
    
    public boolean Cheak(String guess){
        char s;
        int count=0;
        for (int i = 0 ; i < 4 ; i++){
            s = guess.charAt(i);
            for (int j = i + 1 ; j < 4 ; j++){
                if (s == (guess.charAt(j)))
                    count = 1;
                
                if (count == 1){
                    System.out.println("請輸入 4 個不重複數字!");
                    return true;
                }
            }
        }
        return false;
    }
    
    public void Site(String guess){
        int site;
        A=0 ; B=0;
        for (int i = 1 ; i < ab.length ; i++){
            site = guess.indexOf(ab[i]);
            if (site != -1){
                if (site + 1 == i)
                    A+=1;
                else 
                    B+=1;
            }
        }
        System.out.printf("%dA%dB\n",A,B);
        
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
}
