public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int is = -1;
        int js = -1;
        int in = n;
        int jn = n;
        int i = 0;
        int j = 0;
        int count = 0;
        int direct = 0;
        while (true){
            count++;
            matrix[i][j] = count;
            if (count == n * n) break;
            boolean move = false;
            while (!move){
                move = true;
                if (direct == 0){
                    j++;
                    if (j == jn){
                        j--;
                        direct = 1;
                        is++;
                        move = false;
                    }
                } else if (direct == 1){
                    i++;
                    if (i == in){
                        i--;
                        direct = 2;
                        jn--;
                        move = false;
                    }
                } else if (direct == 2){
                    j--;
                    if (j == js){
                        j++;
                        direct = 3;
                        in--;
                        move = false;
                    }
                } else if (direct == 3){
                    i--;
                    if (i == is){
                        i++;
                        direct = 0;
                        js++;
                        move = false;
                    }
                }
            }
        }
        return matrix;
    }
}
