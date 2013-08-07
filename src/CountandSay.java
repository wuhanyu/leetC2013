public class CountandSay {
    public String countAndSay(int n) {
        String result = "1";
        if (n == 0) return "";
        for (int i = 1; i < n; i++){
            String newresult = "";
            int j = 1;
            char cur = result.charAt(0);
            int count = 1;
            while (j < result.length()){
                while (j < result.length() && result.charAt(j) == cur){
                    j++;
                    count++;
                }
                newresult += (char)('0' + count);
                newresult += cur;
                if (j < result.length()) {
                    cur = result.charAt(j);
                    j++;
                    count = 1;
                } else {
                    count = 0;
                }            
            }
            if (count > 0){
                newresult += (char)('0' + count);
                newresult += cur;
            }
            result = newresult;
        }
        return result;
    }
}
