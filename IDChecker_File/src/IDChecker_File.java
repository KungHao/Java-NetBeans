import java.io.*;




public class IDChecker_File {
  
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw_correct = new FileWriter("correct.txt");
            BufferedWriter bw_correct = new BufferedWriter(fw_correct);
            FileWriter fw_error = new FileWriter("error.txt");
            BufferedWriter bw_error = new BufferedWriter(fw_error);
            
            String show = null;
            String line = null;
            ID id = new ID();
            while((line = br.readLine()) != null){
                id.setID(line);
                if (!id.checkIdFormat()){
                    show = line + ", 格式不符";
                    bw_error.write(show);
                    bw_error.newLine();
                }
                else if (!id.checkID()){
                    show = line + ", 身份證字號錯誤";
                    bw_error.write(show);
                    bw_error.newLine();
                }
                else if (id.checkID()){
                    show = line + ", " + id.city() + id.gender();
                    bw_correct.write(show);
                    bw_correct.newLine();
                }
            }
            bw_error.close();
            fw_error.close();
            bw_correct.close();
            fw_correct.close();
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
}
