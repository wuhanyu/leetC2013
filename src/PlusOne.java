public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            result[i + 1] = (digits[i] + plus) % 10;
            plus = (digits[i] + plus) / 10;
        }
        if (plus > 0){
            result[0] = plus;
            return result;
        } else {
            for (int i = 0; i < digits.length; i++){
                digits[i] = result[i + 1]; 
            }
            return digits;
        }
    }
}
