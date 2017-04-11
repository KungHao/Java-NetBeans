package caesar;

import java.util.Scanner;
public class CaesarTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Caesar plain = new Caesar();
        int key,len,j=0,site;//key放金鑰，len放明文長度，site放取得單字位置
        String code = " qwertyuiopasdfghjklzxcvbnm",cipher = "";
        System.out.print("Input Plaintext: ");
        plain.setPlaintext(sc.nextLine());
        System.out.print("Input Key: ");
        key = sc.nextByte();
        len= plain.getPlaintext().length();//取明文長度
        
        for (int i = 1 ; i <= len ; i++){
           if (plain.getPlaintext().substring(j,i).equals(" ")){//看是否為空白
               cipher += " ";
               j++;
           }
           else {
           site=code.indexOf(plain.getPlaintext().substring(j,i));//從code裡面找字
           site += key;
           if (site > 26) site -= 26;//比較是否超出字母表字串範圍
           cipher+= code.charAt(site);
           j++;
           }
        }
        System.out.printf("Ciphertext: %s\n",cipher);
    }
    
}
