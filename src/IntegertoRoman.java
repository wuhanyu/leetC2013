public class IntegertoRoman {
    public String intToRoman(int num) {
        if (num < 1) return "";
        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] romani = {1000, 500, 100, 50, 10, 5, 1};
        String result = "";
        for (int i = 0; i < romani.length; i+=2){
            int count = 0;
            if (num >= romani[i]){
                count = num / romani[i];
                num %= romani[i];
                if (count < 4) {    
                    for (int j = 0; j < count; j++)
                        result += roman[i];
                } else if (count == 4) {
                    result += roman[i];
                    result += roman[i-1];
                } else if (count == 5) {
                    result += roman[i-1];
                } else if (count < 9) {
                    result += roman[i-1];
                    for (int j = 5; j < count; j++)
                        result += roman[i];
                } else {
                    result += roman[i];
                    result += roman[i-2];
                }
            }
        }
        return result;
    }
}
