// Merge Intervals

// Given a collection of intervals, merge all overlapping intervals.

// Example
// Example 1:

// Input: [(1,3)]
// Output: [(1,3)]
// Example 2:

// Input:  [(1,3),(2,6),(8,10),(15,18)]
// Output: [(1,6),(8,10),(15,18)]
// Challenge
// O(n log n) time and O(1) extra space.

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size()<2||intervals==null){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            } 
        });
        Interval ii, jj;
        for (int i=0;i<intervals.size();i++){
            ii=intervals.get(i);
            for (int j=i+1;j<intervals.size();j++){
                jj=intervals.get(j);
                if (ii.end>=jj.start){
                    ii.end=Math.max(ii.end, jj.end);
                    intervals.remove(jj);
                    j--;
                }
            }
        }
        return intervals;
    }
}