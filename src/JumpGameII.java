public class JumpGameII {
    public int jump(int[] A) {
        if (A.length <= 1) return 0;
        int[] jumps = new int[A.length + 1];
        jumps[1] = A[0];
        if (A[0] >= A.length - 1) return 1;
        int maxjump = 1;
        for (int i = 1; i < A.length; i++){
            int j = 1;
            while (j <= maxjump){
                if (jumps[j] >= i){
                    int target = i + A[i];
                    if (target >= A.length - 1){
                        return j + 1;
                    } else if (i + A[i] > jumps[j+1]){
                        jumps[j+1] = i + A[i];
                        if (j + 1 > maxjump) maxjump = j + 1;
                    }
                    break;
                }
                j++;
            }
        }
        return 0;
    }
}
