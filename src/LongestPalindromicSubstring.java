/*
* Manacher's ALGORITHM O(n)
*/
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 1) return "";
        char[] chs = new char[s.length() * 2 + 3];
        chs[0] = '$';
        chs[chs.length - 1] = '^';
        for (int i = 0; i < s.length(); i++) chs[2 * i + 2] = s.charAt(i);
        for (int i = 0; i < s.length() + 1; i++) chs[2 * i + 1] = '#';
        int[] p = new int[chs.length];
        int mx = 0;
        int id = 0;
        for (int i = 1; i < p.length - 1; i++) {
            p[i] = mx > i? Math.min(p[2 * id - i], mx - i) : 1;
            while (chs[i + p[i]] == chs[i - p[i]]) p[i]++;
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }
        int maxi = 1;
        for (int i = 1; i < p.length; i++) {
            if (p[i] > p[maxi]) maxi = i;
        }
        int start = (maxi - p[maxi]) / 2;
        return s.substring(start, start + p[maxi] - 1);
    }
}
