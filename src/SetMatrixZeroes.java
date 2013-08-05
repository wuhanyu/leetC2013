public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;
        boolean[] x = new boolean[m];
        boolean[] y = new boolean[n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    x[i] = true;
                    y[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (x[i] || y[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
