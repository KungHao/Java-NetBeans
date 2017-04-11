package student;
import java.util.Scanner;

public class StudentTest {
    public static void main(String arg[]){
        String name, studentid, classn;
        Scanner input = new Scanner(System.in);
        Student s1 = new Student(),s2 =new Student();
        //讀取命令列引數
        s1.setName(arg[0]);
        s1.setID(arg[1]);
        s1.setMajor(arg[2]);
        //輸入學生2資料
        System.out.print("Input Student's Name:" );
        name = input.nextLine();
        System.out.print("Input Student's ID:");
        studentid = input.nextLine();
        System.out.print("Input Student's Major:");
        classn  = input.nextLine();
        //將學生1set進去
        s2.setName(name);
        s2.setID(studentid);
        s2.setMajor(classn);
        //輸出學生1
        System.out.println("------Student1------" );
        System.out.printf("Name: %s\n",s1.getName());
        System.out.printf("ID: %s\n",s1.getID());
        System.out.printf("Major: %s\n",s1.getMajor());
        //輸出學生2
        System.out.println("------Student2------" );
        System.out.printf("Name: %s\n",s2.getName());
        System.out.printf("ID: %s\n",s2.getID());
        System.out.printf("Major: %s\n",s2.getMajor());
    }
}
