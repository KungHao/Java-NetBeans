package sudoku;

public class Sudoku {
    int[] num = new int[11];
    public Sudoku(){
    System.out.println("Enter the sudoku:");
    }
    
    public void setNum(){
        for (int i = 1 ; i <= 10 ; i++){
            num[i] = i ;
        }
    }
    
    public boolean check(int[][] a){
        //check row
        this.setNum();
        for (int i = 1 ; i < a.length ; i++){
            for (int j = 1 ; j < a[i].length ; j++){
                if (num[a[i][j]] == 0)
                    return false;
                else 
                    num[a[i][j]] = 0;
            }
            this.setNum();
        }
        //check column
        for (int i = 1 ; i < a.length ; i++){
            for (int j = 1 ; j < a[i].length ; j++){
                if (num[a[j][i]] == 0)
                    return false;
                else 
                    num[a[j][i]] = 0;
            }
            this.setNum();
        }
        //check 3*3
        for (int i = 1 ; i < a.length ; i+=3){
            for (int j = 1 ; j < a[i].length ; j+=3){
                for (int x = i ; x < i + 3 ; x++){
                    for (int y = j ; y < j + 3 ; y++){
                         if (num[a[x][y]] == 0)
                             return false;
                        else 
                            num[a[x][y]] = 0;
                    }
                }
                this.setNum();
            }
        }
        return true;
    }
        
    
}
