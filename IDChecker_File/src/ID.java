public class ID {
    private String id = "";
    private char first;
    private final String[] city = {"台北市 ", "臺中市 ", "基隆市 ", "台南市 ", "高雄市 ", 
            "新北市 ", "宜蘭縣 ", "桃園縣 ", "嘉義市 ", "新竹縣 ", 
            "苗栗縣 ", "臺中縣 ", "南投縣 ", "彰化縣 ", "新竹市 ", 
            "雲林縣 ", "嘉義縣 ", "台南縣 ", "高雄縣 ", "屏東縣 ", 
            "花蓮縣 ", "台東縣 ", "金門縣 ", "澎湖縣 ", "陽明山管理局 ", "連江縣 "};
    
    public void setID(String id){
        this.id = id.toUpperCase();//轉大寫
        first = this.id.charAt(0);//取第一個英文字母
    }
    
    //正規化表示法
    public boolean checkIdFormat(){
        return id.matches("[A-Z][1-2]\\d{8}");
    }
    //Show出縣市
    public String city(){
        return city[first - 'A'];
    }
    
    public boolean checkID(){
        /*A-Z的對應數字*/
        int[] idNum= {10,11,12,13,14,15,16,17,34,18,19,20,21,22,35
                  ,23,24,25,26,27,28,29,32,30,31,33};
        int count = 0;
        id = idNum[first - 'A'] + id.substring(1);//把英文字母轉成數值
        count = id.charAt(0) - '0'; //第一個值
        
        for (int i = 1 ; i < 10 ; i++){
            count += (id.charAt(i) - '0') * (10-i);
        }
        
        count += id.charAt(id.length()-1) - '0';//最後一位數
        return count % 10 == 0;
    }
    
    public String gender(){
        if (id.charAt(2) == 49){
            return "男性";
        }
        else
            return "女性";
    }
}
