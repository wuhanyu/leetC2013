public class ValidSudoku {
    static boolean[][] x, y, box;
    public boolean isValidSudoku(char[][] board) {
        x = new boolean[9][9];
        y = new boolean[9][9];
        box = new boolean[9][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    if (x[i][num]) return false;
                    x[i][num] = true;
                    if (y[j][num]) return false;
                    y[j][num] = true;
                    if (box[j / 3 * 3 + i / 3][num]) return false;
                    box[j / 3 * 3 + i / 3][num] = true;
                }
            }
        }
        return true;
    }
}
