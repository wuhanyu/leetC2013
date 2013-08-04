public class NQueensII {

    static boolean[] x, xy, xyn;
  static int[] pos;
    static int num;
    public int totalNQueens(int n) {
        x = new boolean[n];
        xy = new boolean[2 * n - 1];
        xyn = new boolean[2 * n - 1];
        pos = new int[n];
        num = 0;
        explore(0, n);
        return num;
    }
    
    void explore(int level, int n){
    	if (level == n) num += 1;
    	else {
    		for (int i = 0; i < n; i++){
    			if (!x[i] && !xy[n - level + i - 1] && !xyn[level + i]){
    				x[i] = true;
    				xy[n - level + i - 1] = true;
    				xyn[level + i] = true;
    				pos[level] = i;
    				explore(level + 1, n);
    				x[i] = false;
    				xy[n - level + i - 1] = false;
    				xyn[level + i] = false;
    			}
    		}
    	}
    }
}
