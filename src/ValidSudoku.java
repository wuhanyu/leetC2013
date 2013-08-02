public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] flag = null;
        //x
        for (int i = 0; i < 9; i++){
            flag = new boolean[9];
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.') continue;
                if (!flag[board[i][j] - '1']) flag[board[i][j] - '1'] = true;
                else return false;
            }
            
        }
        //y
        for (int i = 0; i < 9; i++){
            flag = new boolean[9];
            for (int j = 0; j < 9; j++){
                if (board[j][i] == '.') continue;
                if (!flag[board[j][i] - '1']) flag[board[j][i] - '1'] = true;
                else return false;
            }
            
        }
        //box
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                flag = new boolean[9];
                for (int k = 0; k < 9; k++){
                    if (board[i * 3 + k / 3][j * 3 + k % 3] == '.') continue;
                    if (!flag[board[i * 3 + k / 3][j * 3 + k % 3] - '1']) flag[board[i * 3 + k / 3][j * 3 + k % 3] - '1'] = true;
                    else return false;                  
                }
            }
            
        }
        return true;
    }
}
