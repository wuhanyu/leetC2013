public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int i = 0;
        int j = 0;
        while (true){
            if (strs[0].length() <= i) break;
            char c = strs[0].charAt(i);
            for (j = 1; j < strs.length; j++){
                if (strs[j].length() <= i || strs[j].charAt(i) != c) break;
            }
            if (j < strs.length) break;
            i++;
        }
        return strs[0].substring(0, i);
    }
}
