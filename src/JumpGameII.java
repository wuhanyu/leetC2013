public class JumpGameII {
    public int jump(int[] A) {
        if (A.length <= 1) return 0;
        int begin = 0;
        int end = 0;
        int count = 0;
        while (true) {
            int newend = 0;
            for (int i = begin; i <= end; i++) {
                if (A[i] + i > newend) newend = A[i] + i;
            }
            if (newend > end) {
                count++;
                if (newend >= A.length - 1) return count;
                else {
                    begin = end + 1;
                    end = newend;
                }
            } else break;
        }
        return -1;
    }
}
