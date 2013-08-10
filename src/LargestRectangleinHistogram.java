import java.util.Stack;

public class LargestRectangleinHistogram {
	public static void main(String[] args){
		int[] height = {2, 1, 2};
		System.out.println(new LargestRectangleinHistogram().largestRectangleArea(height));
	}
	
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        Stack<Integer> indexS = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++){
            if (i < height.length && (indexS.isEmpty() || height[indexS.peek()] <= height[i])){
                indexS.push(i);
            } else {
                int tmp = indexS.pop();
                int width;
                if (indexS.isEmpty()) width = i;
                else width = i - indexS.peek() - 1;
                max = Math.max(max, height[tmp] * width);
                if (i < height.length || !indexS.isEmpty()) i--;
            }
        }
        return max;
    }
}
