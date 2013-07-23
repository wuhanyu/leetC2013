import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_97
 * @problem Given s1, s2, s3, find whether s3 is formed by the interleaving of
 *          s1 and s2.
 * 
 *          For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 *          When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
 *          false.
 */
public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new InterleavingString().isInterleave("bbbcacacccaacbbbabacbbbb", "cbacaaacbcbbbabbacccbaacba", "bcbabbbacacaaaccbccccacbbacbbbaabbaccbabacabbbbcba"));
	}

    public boolean isInterleave(String s1, String s2, String s3) {
        int n, m, t;
        n = s1.length();
        m = s2.length();
        t = s3.length();
        if (n + m != t) return false;
        if (n == 0) return s2.equals(s3);
        if (m == 0) return s1.equals(s3);
        boolean[][][] flag = new boolean[n + 1][m + 1][t + 1];
        Queue<Tri> q = new LinkedList<Tri>();
        q.add(new Tri(0, 0, 0));
        flag[0][0][0] = true;
        while (!q.isEmpty()){
        	Tri tr = q.poll();
        	if (tr.i < n && !flag[tr.i + 1][tr.j][tr.p + 1] &&s1.charAt(tr.i) == s3.charAt(tr.p)){
        		if (tr.p + 1 == t) return true;
        		q.add(new Tri(tr.i + 1, tr.j, tr.p + 1));
        		flag[tr.i + 1][tr.j][tr.p + 1] = true;
        	}
        	if (tr.j < m && !flag[tr.i][tr.j + 1][tr.p + 1]  && s2.charAt(tr.j) == s3.charAt(tr.p)){
        		if (tr.p + 1 == t) return true;
        		q.add(new Tri(tr.i, tr.j + 1, tr.p + 1));
        		flag[tr.i][tr.j + 1][tr.p + 1] = true;
        	}
        }
        return false;
    }
}

class Tri {
	int i, j, p;
	public Tri(int i, int j, int p){
		this.i = i;
		this.j = j;
		this.p = p;
	}
}
