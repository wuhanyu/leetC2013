public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int[] leftHeightest = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++){
            if (height[i] > max) max = height[i];
            leftHeightest[i] = max;
        }
        max = 0;
        for (int i = 1; i < height.length; i++){
            for (int j = i - 1; j >= 0; j--){
                if (i * Math.min(leftHeightest[j], height[i]) < max) break;
                int area = Math.min(height[j], height[i]) * (i - j);
                if (area > max) max = area;
            }
        }
        return max;
    }
}
