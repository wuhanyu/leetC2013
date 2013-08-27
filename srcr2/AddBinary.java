public class Solution {
    public String addBinary(String a, String b) {
        String ar = new StringBuffer(a).reverse().toString();
        String br = new StringBuffer(b).reverse().toString();
        String result = "";
        
        int maxlen = (ar.length() > br.length())? ar.length() : br.length();
        int carry = 0;
        for (int i = 0; i < maxlen; i++){
            int ai = (i < ar.length())? ar.charAt(i) - '0' : 0;
            int bi = (i < br.length())? br.charAt(i) - '0' : 0;
            int val = (ai + bi + carry) % 2;
            carry = (ai + bi + carry) / 2;
            result = (char)('0' + val) + result;
        }
        if (carry == 1) result = "1" + result;
        return result;
    }
}
