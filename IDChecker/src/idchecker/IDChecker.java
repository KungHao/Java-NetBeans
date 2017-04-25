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
                //���Ҩ�����
                case "1":
                    System.out.print("�п�J�����Ҧr��: ");
                    id.setID(sc.next());
                    
                    if (!id.checkIdFormat()){
                        System.out.println("�榡����");
                        break;
                    }
                    
                    if (id.checkID() % 10 == 0)
                        System.out.println("�����Ҧr�����T");
                    else {
                        System.out.println("�����Ҧr�����~");
                        break;
                    }
                    
                    if (id.cheakGender())
                        System.out.printf("�O��X�ͦb%s���k�m�B�ͩO\n", id.city());
                    else 
                        System.out.printf("�O��X�ͦb%s���k�m�B�ͩO\n", id.city());
                    
                    break;
                //���ͨ�����
                case "2":
                    String city, gender;
                    System.out.print("�п�J����: ");
                    city = sc.next();
                    
                    if (!id.creatCity(city)) break;
                    
                    System.out.print("�п�J�ʧO: ");
                    gender = sc.next();
                    
                    if (!id.creatGender(gender)) break;
                    
                    id.creatNewID();
                    System.out.printf("���ͪ������Ҧr����: %s\n", id.getID());
                    System.out.println("�����Ҧr�����T");
                    
                    if (id.cheakGender())
                        System.out.printf("�O��X�ͦb%s��%s�m�B�ͩO\n", city, gender);
                    else 
                        System.out.printf("�O��X�ͦb%s��%s�m�B�ͩO\n", city, gender);
                    break;
                //���}
                case "0":
                    Continue = false;
                    break;
                default:System.out.println("�п�J[1,2,0]");
            }
        }while(Continue);
        
    }
    
}
