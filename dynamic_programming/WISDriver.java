package dynamic_programming;

import java.util.*
;
public class WISDriver {
    public static void main(String[] args) {
        // S is the set of intervals under consideration. Each interval [s_i, f_i, v_i] has
        // a start time, end time, and value. We wish to find a subset of compatible (non-overlapping) 
        // intervals that maximizes total value.
        
        // sample input S of intervals
        int[][] S = {
            {},
            {},
            {},
            {},
            {},
            {},
            {}
        };

        WeightedIntervalScheduling wis = new WeightedIntervalScheduling(S, false);
        int optimalValue = wis.getValue();
        List<Integer> optIntervals = wis.getIntervals();

        System.out.println(optimalValue);
        System.out.println(optIntervals);
    }
}
