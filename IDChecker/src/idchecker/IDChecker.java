package idchecker;

import java.util.Scanner;

public class IDChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean Continue = true;
        do {
            Continue = true;
            ID id = new ID();
            String input = sc.next();
            
            switch (input){
                //驗證身分證
                case "1":
                    System.out.print("請輸入身份證字號: ");
                    id.setID(sc.next());
                    
                    if (!id.checkIdFormat()){
                        System.out.println("格式不符");
                        break;
                    }
                    
                    if (id.checkID() % 10 == 0)
                        System.out.println("身份證字號正確");
                    else {
                        System.out.println("身份證字號錯誤");
                        break;
                    }
                    
                    if (id.cheakGender())
                        System.out.printf("是位出生在%s的男姓朋友呢\n", id.city());
                    else 
                        System.out.printf("是位出生在%s的女姓朋友呢\n", id.city());
                    
                    break;
                //產生身分證
                case "2":
                    String city, gender;
                    System.out.print("請輸入縣市: ");
                    city = sc.next();
                    
                    if (!id.creatCity(city)) break;
                    
                    System.out.print("請輸入性別: ");
                    gender = sc.next();
                    
                    if (!id.creatGender(gender)) break;
                    
                    id.creatNewID();
                    System.out.printf("產生的身份證字號為: %s\n", id.getID());
                    System.out.println("身份證字號正確");
                    
                    if (id.cheakGender())
                        System.out.printf("是位出生在%s的%s姓朋友呢\n", city, gender);
                    else 
                        System.out.printf("是位出生在%s的%s姓朋友呢\n", city, gender);
                    break;
                //離開
                case "0":
                    Continue = false;
                    break;
                default:System.out.println("請輸入[1,2,0]");
            }
        }while(Continue);
        
    }
    
}
