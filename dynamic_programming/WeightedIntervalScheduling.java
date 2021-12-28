package dynamic_programming;

import java.util.*;

/**
 * Implementation of the dynamic programming solution to the classic Weighted Interval Scheduling problem.
 * First in a series of implementations corresponding to topics covered in Kleinberg and Tardos's book, Algorithm Design.
 */
public class WeightedIntervalScheduling {
    // input set S of intervals
    int[][] S;
    // lookup array for P[i] for each interval i
    int[] P;
    // our memoization table
    int[] M;
    // optimal subset of intervals
    List<Integer> intervals;

    public WeightedIntervalScheduling(int[][] S, boolean recursive) {
        this.S = S;
        this.M = new int[S.length];

        // We sort S in non-decreasing order of finish times to leverage the resulting ordered structure.
        // This takes us O(n log n) time    
        Arrays.sort(S, (a, b) -> a[1] - b[1]);

        // We know compute p(i) for each i, 0 <= i < n
        // p(i) is the immediately preceding interval to interval i such that p(i) finishes before i starts.

        // We compute our DP solution, populating our memoization table.
        if (recursive) {
            recursiveWIS();
        } else {
            iterativeWIS();
        }

        this.intervals = recoverIntervals();
    }

    private void recursiveWIS() {

    }

    private void iterativeWIS() {

    }

    private List<Integer> recoverIntervals() {
        // using our resulting mem-table we can determine which intervals belong in the optimal subset.
        return null;
    }

    public int getValue() {
        // the value obtained by our optimal set of intervals is the entry
        // to corresponding to taking all elements in consideration – the last entry of our memoization array.
        return this.M[this.M.length - 1];
    }

    public List<Integer> getIntervals() {
        return this.intervals;
    }
}
