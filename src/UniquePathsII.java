public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) return 0;
        int m = obstacleGrid[0].length;
        if (m == 0) return 0;
        int[][] dp = new int[n][m];
        if (obstacleGrid[0][0] == 0) dp[0][0]=1;
        for (int i = 1; i < n; i++){
            if (obstacleGrid[i][0] == 0) dp[i][0] = dp[i-1][0];
        }
        for (int i = 1; i < m; i++){
            if (obstacleGrid[0][i] == 0) dp[0][i] = dp[0][i-1];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
