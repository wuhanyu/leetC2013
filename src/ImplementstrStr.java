public class ImplementstrStr {
    public String strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++){
            int j = 0; 
            while (j < needle.length()){
                if (haystack.charAt(i+j) != needle.charAt(j)) break; 
                j++;
            }
            if (j == needle.length()) return haystack.substring(i);
        }
        return null;
    }
}
