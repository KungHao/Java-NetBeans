package Account;
import java.util.Scanner;
//尚未判斷非數值輸入資料
public class AccountTest {
    
    public static void main(String[] args) {
        Boolean continueinput=true;
        Account account1 = new Account();
        Scanner sc = new Scanner(System.in);
        int num, balance=-1,amount;
        //判斷是否輸入01234
        do{
            System.out.print("***Main Menu***\n1)開戶\n2)存款\n3)提款\n"
                   + "4)目前餘額\n0)Exit\n\nPlease enter an number in [1,2,3,4,0]:");
            num = sc.nextInt();
            try {//避免exception
            if (num > 0 && num <= 4){
                switch (num){
                case 1 ://開戶
                        if (balance < 0){
                            System.out.print("請輸入開戶金額(開戶金額必須>=1000):");
                            balance=sc.nextInt();
                            if (balance>=1000){//開戶金額必須大於等於1000
                                account1.account(balance);
                                System.out.printf("開戶成功!存入$%d元\n\n",account1.getBalance());
                            }
                            else {
                                System.out.println("開戶金額不足!\n");
                                balance = -1;
                                break;
                            }
                        }
                        else 
                            System.out.println("已開戶!\n");
                        break;
                case 2 ://存款
                        if (balance < 0){
                            System.out.println("未開戶Q\n");
                            break;
                        }
                        System.out.print("請輸入存款金額: ");
                        
                            amount=sc.nextInt();
                            if (amount>=0){
                            account1.add(amount);
                            System.out.printf("成功存入%d元!\n\n",amount);
                            }
                            else if (amount <0){
                                System.out.println("存款失敗!請輸入非負數值!\n");
                                break;
                        } 
                        break;
                case 3 ://提款
                        if (balance < 0){
                            System.out.println("未開戶!\n");
                            break;
                        }
                        System.out.print("請輸入提款金額: ");
                        amount = sc.nextInt();
                        if (amount > account1.getBalance())
                            System.out.println("提款失敗!提款金額大於目前餘額!\n");
                        else if (amount <0){
                            System.out.println("提款失敗!請輸入非負數值!\n");
                            break;
                        }
                        else {
                            account1.minus(amount);
                            System.out.printf("成功領出%d元!\n\n",amount);
                        }
                        break;
                case 4 ://目前餘額
                        if (balance < 0){
                            System.out.println("未開戶!\n");
                            break;
                        }
                        System.out.printf("目前餘額:%d元\n\n", account1.getBalance());
                        break;
                }
            }
            else if (num == 0){//離開程式
                System.exit(0);
                }
            else {
                System.out.println("請輸入[1,2,3,4,0]\n");
            }
            }
            catch (Exception e){//輸入非數值資料時
                switch (num) {
                    case 2:
                        System.out.println("存款失敗!請輸入金額\n");
                        break;
                    case 3:
                        System.out.println("提款失敗!請輸入金額\n");
                        break;
                    default:
                        System.out.println("請輸入數值\n");
                        break;
                }
                sc.nextLine();//處理非數值輸入的rubbish number
            } 
        }while(continueinput);
    }
}
