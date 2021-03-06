import java.util.ArrayList;

public class SudokuSolver {
    static boolean[][] x, y, box;
    public void solveSudoku(char[][] board) {
        x = new boolean[9][9];
        y = new boolean[9][9];
        box = new boolean[9][9];
        ArrayList<Point> q = new ArrayList<Point>();
        //init
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    q.add(new Point(i, j));
                } else {
                    int num = board[i][j] - '1';
                    x[i][num] = true;
                    y[j][num] = true;
                    box[j / 3 * 3 + i / 3][num] = true;
                }
            }
        }
        
        explore(0, board, q);
    }
    
    boolean explore(int level, char[][] board, ArrayList<Point> q){
        if (level == q.size()) return true;
        int i = q.get(level).x;
        int j = q.get(level).y;
        for (int k = 0; k < 9; k++){
            if (!x[i][k] && !y[j][k] && !box[j / 3 * 3 + i / 3][k]){
                x[i][k] = true;
                y[j][k] = true;
                box[j / 3 * 3 + i / 3][k] = true;
                board[i][j] = (char)(k + '1');
                if (explore(level + 1, board, q)) return true;
                x[i][k] = false;
                y[j][k] = false;
                box[j / 3 * 3 + i / 3][k] = false;                
            }
        }
        return false;
    }
}

class Point {
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
