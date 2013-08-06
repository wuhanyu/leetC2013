/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() > 1){
            quickSort(0, intervals.size() - 1, intervals);
            int i = 0;
            while (i < intervals.size() - 1){
                if (intervals.get(i).end >= intervals.get(i + 1).start){
                    if (intervals.get(i+1).end > intervals.get(i).end)
                        intervals.get(i).end = intervals.get(i+1).end;
                    intervals.remove(i+1);
                } else {
                    i++;
                }
            }
        }
        return intervals;
    }
    
    void quickSort(int start, int end, ArrayList<Interval> intervals) {
        Interval tmp = intervals.get(start);
        int i = start;
        int j = end;
        while (i < j){
            while (i < j && intervals.get(j).start > tmp.start) j--;
            if (i < j) intervals.set(i, intervals.get(j));
            while (i < j && intervals.get(i).start <= tmp.start) i++;
            if (i < j) intervals.set(j, intervals.get(i));
        }
        intervals.set(i, tmp);
        if (start < i - 1) quickSort(start, i - 1, intervals);
        if (i + 1 < end) quickSort(i + 1, end, intervals);
    }
}
