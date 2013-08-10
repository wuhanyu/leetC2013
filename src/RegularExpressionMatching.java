public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(0, 0, s, p);
    }
    
    public boolean isMatch(int si, int pi, String s, String p){
        if (si == s.length() && pi == p.length()) return true;
        if (pi >= p.length()) return false;
        if (pi < p.length() - 1 && p.charAt(pi + 1) == '*'){
            if (isMatch(si, pi + 2, s, p)) return true;
        }
        if (si >= s.length()) return false;
        if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) ==  '.'){
            if (pi < p.length() - 1 && p.charAt(pi + 1) == '*'){
                return isMatch(si + 1, pi, s, p);
            } else {
                return isMatch(si + 1, pi + 1, s, p);
            }
        } else if (p.charAt(pi) == '*'){
            return isMatch(si, pi + 1, s, p);
        }
        return false;
    }
}
