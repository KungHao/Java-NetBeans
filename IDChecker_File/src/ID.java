public class ID {
    private String id = "";
    private char first;
    private final String[] city = {"�x�_�� ", "�O���� ", "�򶩥� ", "�x�n�� ", "������ ", 
            "�s�_�� ", "�y���� ", "��鿤 ", "�Ÿq�� ", "�s�˿� ", 
            "�]�߿� ", "�O���� ", "�n�뿤 ", "���ƿ� ", "�s�˥� ", 
            "���L�� ", "�Ÿq�� ", "�x�n�� ", "������ ", "�̪F�� ", 
            "�Ὤ�� ", "�x�F�� ", "������ ", "��� ", "�����s�޲z�� ", "�s���� "};
    
    public void setID(String id){
        this.id = id.toUpperCase();//��j�g
        first = this.id.charAt(0);//���Ĥ@�ӭ^��r��
    }
    
    //���W�ƪ�ܪk
    public boolean checkIdFormat(){
        return id.matches("[A-Z][1-2]\\d{8}");
    }
    //Show�X����
    public String city(){
        return city[first - 'A'];
    }
    
    public boolean checkID(){
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
        return count % 10 == 0;
    }
    
    public String gender(){
        if (id.charAt(2) == 49){
            return "�k��";
        }
        else
            return "�k��";
    }
}
