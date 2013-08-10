public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[] height = new int[m + 1];
        int[] stack = new int[m + 1];
        int top = -1;
        int max = 0;  
        for (int i = 0;  i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] == '0') height[j] = 0;
                else height[j]++;
            }
            
            top = -1;
            for (int j = 0; j < height.length; j++){                   
                if (top < 0 || height[stack[top]] <= height[j]){
                    top++;
                    stack[top] = j;
                } else {
                    int tmp = stack[top];
                    top--;
                    int width;
                    if (top < 0) width = j;
                    else width = j - stack[top] - 1;
                    max = Math.max(max, height[tmp] * width);
                    j--;
                }
            }
        }
        return max;
    }
}
