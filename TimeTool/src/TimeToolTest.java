import java.util.Scanner;
public class TimeToolTest {

	public static void main(String[] args) {
		String input = null;
		Scanner sc = new Scanner(System.in);
            
		do {
                    try {
			System.out.println("***Main Menu***");
			System.out.println("1) Show The Current Time");
			System.out.println("2) Leap Year");
                        System.out.println("3) Show the Calender");
			System.out.println("0) Exit\n");
			System.out.print("Please enter a number in [1,2,3,0]: ");

			input = sc.next();
			int num = Integer.parseInt(input); 
			switch (num) {
			case 1://顯示目前時間
				TimeTool.showCurrentTime(); 
				break;
			case 2://檢測是否為閏年
				System.out.print("Please enter the number of year: ");
				int year = sc.nextInt(); 
				if (TimeTool.LeapYear(year))
					System.out.println(year + " is a leap year.\n");
				else
					System.out.println(year + " is not a leap year.\n");
				break;
                        case 3: //月曆
                                TimeTool day = new TimeTool();
                                System.out.print("Year: ");
                                int year1 = sc.nextInt();
                                System.out.print("Month: ");
                                int month = sc.nextInt();
                                System.out.println("\nSun\tMon\tTue\tWed\tThu\tFri\tSat");
                                
                                for (int i = 1 ; i< year1 ; i++){//把年加總
                                    if (TimeTool.LeapYear(i))
                                        day.AddDay(366);
                                    else 
                                        day.AddDay(365);
                                }
                                
                                for (int j = 1 ; j < month ; j++)//把月加總
                                    day.AddDay(day.MonthDay(year1, j));
                                
                                
                                int days = day.GetDay()%7 ;
                                for (int i = 1 ; i <= days ;i++){//把輸出移到1號
                                    System.out.print("\t");
                                }
                                
                                for (int i = 1 ; i <= day.MonthDay(year1, month) ; i++,days++){//輸出
                                    if (days == 0)
                                        System.out.printf("%s\t",i);
                                    else 
                                        System.out.printf("%s\t",i);
                                    if (days == 6){
                                        System.out.print("\n");
                                        days=-1;}
                                }
                                System.out.println("\n");
                                break;
			}
                    }
                    catch (NumberFormatException e){
                        System.out.println("輸入錯誤\n");
                    }
		} while (!input.equals("0")); 
            
            
	}
}