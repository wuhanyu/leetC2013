public class MinimumWindowSubstring {
    public String minWindow(String S, String T) { 
        String minStr = "";
        int minLength = Integer.MAX_VALUE;
        if (T.length() == 0) return minStr;
        int[] count = new int[100];
        boolean[] flag = new boolean[100];
        for (int i = 0; i < T.length(); i++) {
            count[T.charAt(i) - 'A']++;
            flag[T.charAt(i) - 'A'] = true;
        }
        int rem = T.length();
        int i = 0;
        int j = 0;
        while (i <= S.length() - T.length()){
            while (j < S.length() && rem > 0){
                if (flag[S.charAt(j) - 'A']){
                    if (count[S.charAt(j) - 'A'] > 0) rem--;
                    count[S.charAt(j) - 'A'] --;       
                }
                j++;
            }
            if (rem == 0){
                while (i <= S.length() - T.length() && (!flag[S.charAt(i) - 'A'] || count[S.charAt(i) - 'A'] < 0)){
                    if (count[S.charAt(i) - 'A'] < 0) count[S.charAt(i) - 'A']++;
                    i++;
                }
                if (j - i < minLength){
                    minStr = S.substring(i, j);
                    minLength = j - i;
                }
                count[S.charAt(i) - 'A']++;
                rem++;
            }
            i++;
        }
        return minStr;
    }
}
