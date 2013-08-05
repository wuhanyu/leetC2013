public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;
        boolean x = false;
        boolean y = false;
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) x = true;
        for (int i = 0; i < n; i++)
            if (matrix[0][i] == 0) y = true;
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (x){
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
        if (y){
            for (int i = 0; i < n; i++) matrix[0][i] = 0;
        }
    }
}
