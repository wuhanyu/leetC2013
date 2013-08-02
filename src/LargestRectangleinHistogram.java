public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        int maxarea = 0;
        for (int i = 0; i < height.length; i++){
            if (i > 0 && height[i] == height[i-1]) continue;
            int s = i;
            while (s > 0 && height[s-1] >= height[i]) s--;
            int t = i;
            while (t < height.length - 1 && height[t+1] >= height[i]) t++;
            int area = (t - s + 1) * height[i];
            if (area > maxarea) maxarea = area;
        }
        return maxarea;
    }
}
