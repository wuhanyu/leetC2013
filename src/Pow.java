public class Pow {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (Math.abs(x - 0) < 0.0000001) return 0;
        if (Math.abs(x - 1) < 0.0000001) return 1;
        if (Math.abs(x + 1) < 0.0000001){
            if (n % 2 == 0) return 1;
            else return -1;
        }
        double result;
        if (n < 0){
            result = 1;
            n *= -1;
            for (int i = 0; i < n; i++) result /= x;
        } else {
            result = 1;
            for (int i = 0; i < n; i++){
                if (Math.abs(result - 0) < 0.0000001) return 0;
                result *= x;
            }
        }
        return result;
    }
}
