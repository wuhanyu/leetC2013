public class RomantoInteger {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] romani = {1000, 500, 100, 50, 10, 5, 1};
        int result = 0;
        int curIndex = -1;
        int index = 0;
        int[] ii = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ii[i] = getIndex(s.charAt(i), roman);
        }
        int[] minright = new int[s.length()];
        int min = 100;
        for (int i = s.length() - 1; i >= 0; i--){
            if (ii[i] < min) min = ii[i];
            minright[i] = min;
        }
        for (int i = 0; i < s.length(); i++){
            if (ii[i] > minright[i]) result -= romani[ii[i]];
            else result += romani[ii[i]];
        }
        return result;
    }
    
    int getIndex(char c, char[] roman){
        for (int i = 0; i < roman.length; i++){
            if (c == roman[i]) return i;
        }
        return -1;
    }
}
