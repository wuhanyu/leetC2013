public class Sqrt {
    public int sqrt(int x) {
        if (x <= 0) return 0;
        int i = 1;
        while (i * i > 0){
            if (i * i > x) break;
            i++;
        }
        return i - 1;
    }
}
