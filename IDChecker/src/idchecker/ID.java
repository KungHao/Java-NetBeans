package idchecker;



public class ID {
    private String id, creatID = "";
    private char first;
    private final String[] city = {"�x�_��", "�O����", "�򶩥�", "�x�n��", "������", 
            "�s�_��", "�y����", "��鿤", "�Ÿq��", "�s�˿�", 
            "�]�߿�", "�O����", "�n�뿤", "���ƿ�", "�s�˥�", 
            "���L��", "�Ÿq��", "�x�n��", "������", "�̪F��", 
            "�Ὤ��", "�x�F��", "������", "���", "�����s�޲z��", "�s����"};
    public ID(){//�غc��
        System.out.print("********************\n" + 
                         "1. ���Ҩ����Ҹ��X\n" +
                         "2. ���ͨ����Ҧr��\n" +
                         "0. ���}\n" +
                         "********************\n" +
                         "�п��: ");
    }
    public void setID(String id){
        this.id = id.toUpperCase();//��j�g
        first = this.id.charAt(0);//���Ĥ@�ӭ^��r��
    }
    
    public String getID(){
        return id;
    }
    //���W�ƪ�ܪk
    public boolean checkIdFormat(){
        return id.matches("[A-Z][1-2]\\d{8}");
    }
    //Show�X����
    public String city(){
        return city[first - 'A'];
    }
    
    public int checkID(){
        /*A-Z�������Ʀr*/
        int[] idNum= {10,11,12,13,14,15,16,17,34,18,19,20,21,22,35
                  ,23,24,25,26,27,28,29,32,30,31,33};
        int count = 0;
        id = idNum[first - 'A'] + id.substring(1);//��^��r���ন�ƭ�
        count = id.charAt(0) - '0'; //�Ĥ@�ӭ�
        
        for (int i = 1 ; i < 10 ; i++){
            count += (id.charAt(i) - '0') * (10-i);
        }
        count += id.charAt(id.length()-1) - '0';//�̫�@���
        return count;
    }
    
    public boolean cheakGender(){
        return id.charAt(2) == 49;//�O�k�ͶǦ^True
    }
    
    //Case 2: Creat ID
    public boolean creatCity(String input){
        for (int i = 0 ; i < city.length ; i++) {
            if (city[i].equals(input)){
                creatID += ((char)(i + 65));
                return true;
            }
        }
        System.out.println("�������~");
        return false;
    }
    
    public boolean creatGender(String input){
        switch (input) {
            case "�k":
                creatID += "1";
                return true;
            case "�k":
                creatID += "2";
                return true;
            default:
                System.out.println("�ʧO���~");
                return false;
        }
    }
    
    public void creatNewID(){
        //���ͤC�Ӷü�
        for (int i = 1 ; i < 8 ; i++){
            creatID += String.valueOf((int)(Math.random()* 10));
        }
        this.setID(creatID);
        id += String.valueOf(10 -( (this.checkID()-(id.charAt(id.length()-1) - '0')) % 10));//�ˮֽX
    }
}
