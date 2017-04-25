
import java.io.IOException;

public class RankingTest {

    public static void main(String[] args) throws IOException {
        Ranking rk = new Ranking();
        Language lan = new Language();
        rk.Filereader();
        String[] result = rk.Findtarget();
        int count = 0 ;
        for (int i = 7 ; i < result.length ; i++){
            count++;
            switch (count % 5){//根據數據顯示
                case 0:rk.Filewrite(lan.getRank(), lan.getLanguage(), lan.getRate());
                case 1:lan.setRank(result[i]);
                case 3:lan.setLanguage(result[i]);
                case 4:lan.setRate(result[i]);
            }
            
        }
        
        
        
    }
}
