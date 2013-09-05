public class Solution {
    public String addBinary(String a, String b) {
        int maxlen = Math.max(a.length(), b.length());
        String ar = reverse(a);
        String br = reverse(b);
        String result = "";
        int plus = 0;
        for (int i = 0; i < maxlen; i++){
            int ai = (i < ar.length()) ? ar.charAt(i) - '0' : 0;
            int bi = (i < br.length()) ? br.charAt(i) - '0' : 0;
            int val = (ai + bi + plus) & 1;
            plus = (ai + bi + plus) >> 1;
            result += (char)('0' + val);
        }
        if (plus > 0) result += '1';
        return reverse(result);
    }
    
    String reverse(String input){
        return new StringBuilder(input).reverse().toString();
    }
}
