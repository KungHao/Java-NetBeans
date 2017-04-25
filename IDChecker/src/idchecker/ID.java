package idchecker;



public class ID {
    private String id, creatID = "";
    private char first;
    private final String[] city = {"台北市", "臺中市", "基隆市", "台南市", "高雄市", 
            "新北市", "宜蘭縣", "桃園縣", "嘉義市", "新竹縣", 
            "苗栗縣", "臺中縣", "南投縣", "彰化縣", "新竹市", 
            "雲林縣", "嘉義縣", "台南縣", "高雄縣", "屏東縣", 
            "花蓮縣", "台東縣", "金門縣", "澎湖縣", "陽明山管理局", "連江縣"};
    public ID(){//建構式
        System.out.print("********************\n" + 
                         "1. 驗證身分證號碼\n" +
                         "2. 產生身份證字號\n" +
                         "0. 離開\n" +
                         "********************\n" +
                         "請選擇: ");
    }
    public void setID(String id){
        this.id = id.toUpperCase();//轉大寫
        first = this.id.charAt(0);//取第一個英文字母
    }
    
    public String getID(){
        return id;
    }
    //正規化表示法
    public boolean checkIdFormat(){
        return id.matches("[A-Z][1-2]\\d{8}");
    }
    //Show出縣市
    public String city(){
        return city[first - 'A'];
    }
    
    public int checkID(){
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
        return count;
    }
    
    public boolean cheakGender(){
        return id.charAt(2) == 49;//是男生傳回True
    }
    
    //Case 2: Creat ID
    public boolean creatCity(String input){
        for (int i = 0 ; i < city.length ; i++) {
            if (city[i].equals(input)){
                creatID += ((char)(i + 65));
                return true;
            }
        }
        System.out.println("縣市錯誤");
        return false;
    }
    
    public boolean creatGender(String input){
        switch (input) {
            case "男":
                creatID += "1";
                return true;
            case "女":
                creatID += "2";
                return true;
            default:
                System.out.println("性別錯誤");
                return false;
        }
    }
    
    public void creatNewID(){
        //產生七個亂數
        for (int i = 1 ; i < 8 ; i++){
            creatID += String.valueOf((int)(Math.random()* 10));
        }
        this.setID(creatID);
        id += String.valueOf(10 -( (this.checkID()-(id.charAt(id.length()-1) - '0')) % 10));//檢核碼
    }
}
