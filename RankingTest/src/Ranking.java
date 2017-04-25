import java.io.*;
import java.util.regex.*;

public class Ranking {
    private StringBuilder sb = new StringBuilder();
    String w = null;
    FileWriter fw = new FileWriter("output.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    int count = 0;
    
    public Ranking() throws IOException{
        w = "Rank\tProgramming Language\tRatings";
        bw.write(w);
        bw.newLine();
        
    }
    
    public void Filereader(){
        try{
            FileReader fr = new FileReader("index.html");
            BufferedReader br = new BufferedReader(fr);
            
            String line = new String();
            
            while ((line = br.readLine()) != null){
                sb.append(line);
            }
            br.close();
            fr.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void Filewrite(String rank, String language, String rate){
        try {
            count++;
            w = rank + "\t" + language + "\t\t" + rate;
            bw.write(w);
            bw.newLine();
            if (count == 20){
                bw.close();
                fw.close();
            }
                
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        
    }
    
    public String[] Findtarget(){
        Pattern target = Pattern.compile("<table.*?table-top20.*?</table>",Pattern.CASE_INSENSITIVE);//找到table-top20的表格
        Matcher matcher = target.matcher(sb.toString());//正規化
        String tmp=null;
        while (matcher.find()){
            tmp = matcher.group();
            tmp = tmp.replaceAll("<{1}[^>]{1,}>{1}", "#").trim();//[^>]表示不包含>，{1,}至少一次
        }
        String [] result = tmp.split("#{2,}");
        for (String result1 : result) {
            //System.out.println(result1);
        }
        return result;
    }
    
    
}
