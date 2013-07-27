public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int lastcount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            count++;
            if (s.charAt(i) == ' '){
                if (count > 1) lastcount = count - 1;
                count = 0;
            }
        }
        if (count > 0)
            return count;
        else
            return lastcount;
    }
}
