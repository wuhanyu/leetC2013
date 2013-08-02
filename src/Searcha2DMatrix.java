public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        return search(0, n-1, 0, m-1, matrix, target);
    }
    
    boolean search(int is, int id, int js, int jd, int[][] matrix, int target){
        if (is > id) return false;
        if (js > jd) return false;
        int im = is + (id - is) / 2;
        int jm = js + (jd - js) / 2;
        if (target == matrix[im][jm]) return true;
        else if (target > matrix[im][jm]){
            if (search(is, im, jm + 1, jd, matrix, target)) return true;
            if (search(im + 1, id, js, jd, matrix, target)) return true;
        } else {
            if (search(im, id, js, jm - 1, matrix, target)) return true;
            if (search(is, im - 1, js, jd, matrix, target)) return true;
        }
        return false;
    }
}
