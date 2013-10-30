public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        int max = 1;
        HashMap<Integer, Node> dict = new HashMap<Integer, Node>();
        for (int i = 0; i < num.length; i++) {
            if (!dict.containsKey(num[i])) {
                int left = (dict.containsKey(num[i] - 1) ? dict.get(num[i] - 1).left : num[i]);
                int right = (dict.containsKey(num[i] + 1) ? dict.get(num[i] + 1).right : num[i]);
                dict.put(num[i], new Node());
                dict.get(left).right = right;
                dict.get(right).left = left;
                if (right - left + 1 > max) max = right - left + 1;
            }
        }
        return max;
    }
}

class Node {
    public int left, right;
}
