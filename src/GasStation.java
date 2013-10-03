public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return -1;
        int start = 0;
        int end = 1;
        int sum = gas[0] - cost[0];
        while (start < gas.length) {
            if (end == gas.length) end = 0;
            if (sum >= 0 && start == end) return start;
            if (sum < 0) {
                sum -= gas[start] - cost[start];
                start++;
                if (end == start) {
                    sum += gas[start] - cost[start];
                    end++;
                }
            } else {
                sum += gas[end] - cost[end];
                end++;
            }
        }
        return -1;
    }
}
