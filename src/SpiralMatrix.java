public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = matrix.length;
        if (n == 0) return result;
        int m = matrix[0].length;
        if (m == 0) return result;
        int ns = -1;
        int ne = n;
        int ms = -1;
        int me = m;
        int direct = 1;
        int count = 1;
        int i = 0;
        int j = 0;
        result.add(matrix[0][0]);
        while (count < m * n){
            boolean move = false;
            while (!move){
                move = true;
                if (direct == 0){
                    i++;
                    if (i == ne){
                        i--;
                        me--;
                        direct = 3;
                        move = false;
                    }
                } else if (direct == 1){
                    j++;
                    if (j == me){
                        j--;
                        ns++;
                        direct = 0;
                        move = false;
                    }
                } else if (direct == 2){
                    i--;
                    if (i == ns){
                        i++;
                        ms++;
                        direct = 1;
                        move = false;
                    }
                } else if (direct == 3){
                    j--;
                    if (j == ms){
                        j++;
                        ne--;
                        direct = 2;
                        move = false;
                    }
                }
            }
            count++;
            result.add(matrix[i][j]);
        }
        return result;
    }
}
