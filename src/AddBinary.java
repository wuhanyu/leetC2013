public class AddBinary {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = Math.max(a.length(), b.length()) + 1;
        if (n == 1) return "";
        char[] chs = new char[n];
        int i = a.length() - 1;
        int j = b.length() - 1;
        int p = n - 1;
        int plus = 0;
        while (i >= 0 && j >= 0){
            int ai = a.charAt(i) - '0';
            int bi = b.charAt(j) - '0';
            int ri = (ai + bi + plus) % 2;
            plus = (ai + bi + plus) / 2;
            if (ri == 0) chs[p] = '0';
            else chs[p] = '1';
            i--;
            j--;
            p--;
        }
        while (i >= 0){
            int ai = a.charAt(i) - '0';
            int ri = (ai + plus) % 2;
            plus = (ai + plus) / 2;
            if (ri == 0) chs[p] = '0';
            else chs[p] = '1';
            i--;
            p--;
        }
        while (j >= 0){
            int bi = b.charAt(j) - '0';
            int ri = (bi + plus) % 2;
            plus = (bi + plus) / 2;
            if (ri == 0) chs[p] = '0';
            else chs[p] = '1';
            j--;
            p--;
        }
        if (plus > 0) chs[0] = '1';
        else chs[0] = '0';
        String result = String.valueOf(chs);
        if (plus == 0) result = result.substring(1, result.length());
        return result;
    }
}
