public class SingleNumberII {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A.length == 0) return 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < A.length; i++) {
            int tones = (ones ^ A[i]) & ~twos;
            int ttwos = (ones & A[i]) | (twos & ~A[i]);
            ones = tones;
            twos = ttwos;
        }
        return ones;
    }
}
