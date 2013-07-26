import java.util.ArrayList;

public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        getResult(0, 0, n, result, "");
        return result;
    }
    void getResult(int leftnum, int rightnum, int n, ArrayList<String> result, String s){
        if (leftnum == n && rightnum == n) {
            result.add(s);
        } else {
            if (leftnum < n) getResult(leftnum + 1, rightnum, n, result, s + "(");
            if (rightnum < leftnum) getResult(leftnum, rightnum + 1,  n, result, s + ")");
        }
    }
}
