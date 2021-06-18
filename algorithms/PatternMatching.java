package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PatternMatching {

    /**
     * Brute force approach.
     * Worst case run-time: O((n - m + 1) * m) ~ O(n * m)
     * @param text
     * @param pattern
     * @return array of indices of all matches found.
     */
    public static List<Integer> naive(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        ArrayList<Integer> matches = new ArrayList<>();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            
            while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            if (j == m) {
                matches.add(i);
            }
        }
        return matches;
    }
    
    /**
     * Checks whether s1 is a subsequence of s2.
     * @param s1    pattern
     * @param s2    text
     * @return      boolean indicating truth value of: s1 is a subsequence of s2.
     */
    public static boolean isSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (j < s2.length() && i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == s1.length()) {
            return true;
        } else {
            return false;
        }
    }
}
