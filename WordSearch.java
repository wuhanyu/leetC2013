public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        int n = board.length;
        if (n == 0) return false;
        int m = board[0].length;
        if (m == 0) return false;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (explore(board, word, visited, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    boolean explore(char[][] board, String word, boolean[][] visited, int i, int j, int cur){
        if (cur == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false; 
        if (visited[i][j]) return false;
        if (board[i][j] == word.charAt(cur)){
            visited[i][j] = true;
            if (explore(board, word, visited, i+1, j, cur+1)) return true;
            if (explore(board, word, visited, i, j+1, cur+1)) return true;
            if (explore(board, word, visited, i-1, j, cur+1)) return true;
            if (explore(board, word, visited, i, j-1, cur+1)) return true;
            visited[i][j] = false;
        }
        return false;
    }
}
