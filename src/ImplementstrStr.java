//KMP
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0) return haystack;
        if (haystack.length() == 0) return null;
        int[] pattern = buildPattern(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++){
            while (j >= 0 && needle.charAt(j+1) != haystack.charAt(i)) j = pattern[j];
            if (needle.charAt(j+1) == haystack.charAt(i)) j++;
            if (j == needle.length() - 1) return haystack.substring(i - needle.length() + 1);
        }
        return null;
    }
    
    int[] buildPattern(String input){
        int[] result = new int[input.length()];
        result[0] = -1;
        int j = -1;
        for (int i = 1; i < input.length(); i++){
            while (j >= 0 && input.charAt(j+1) != input.charAt(i)) j = result[j];
            if (input.charAt(j+1) == input.charAt(i)) j++;
            result[i] = j;
        }
        return result;
    }
}
