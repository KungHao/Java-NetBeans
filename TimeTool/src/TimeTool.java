import java.util.Date;
public class TimeTool {
	private int day=1;
	public static void showCurrentTime() {
		Date now = new Date();
		System.out.println(now + "\n");
	}
        
        public int GetDay(){
            return day;
        }
        
        public void AddDay(int day){
            this.day += day;
        }    
        
	public static boolean LeapYear(int year) {
		boolean LeapYear = false;
		
		if((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0)
			LeapYear = true;
		
		return LeapYear;
	}
        
        public int MonthDay(int year,int month){
            switch (month){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                            return 31;
                    case 2:
                            if (LeapYear(year)){
                                return 29;
                            }
                            else{
                                return 28;
                            }
                    default:
                            return 30;
            }
}
}
