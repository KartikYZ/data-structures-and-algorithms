package problems;

import java.util.*;

public class RabbitHole {

    public static void main(String[] args) {
        // N = 5
        // L = [4, 3, 5, 1, 2]
        int N = 5;
        int[] L = {2, 4, 2, 2, 3};
        int V = getMaxVisitableWebpages(N, L);

        System.out.println(V);
    }

    public static int getMaxVisitableWebpages(int N, int[] L) {
        int[] depths = new int[N + 1];
        Stack<Integer> stack = new Stack<>();
        int maxDepth = 1;

        for (int i = 1; i < N + 1; i++) {
            HashMap<Integer, Integer> history = new HashMap<>();
            int current = i;
            int depth = 1;

            boolean alreadySeen = false;
            while (!history.containsKey(current)) {
                if (depths[current] > 0) { 
                    alreadySeen = true;
                    break;
                }

                history.put(current, depth);
                stack.push(current);
                depth++;
                current = L[current - 1];
            }

            if (alreadySeen) {
                int knownDepth = depths[current];
                while (!stack.isEmpty()) {
                    depths[stack.pop()] = ++knownDepth;
                }
                continue;
            }

            int cycleLength = depth - history.get(current);
            depths[current] = cycleLength;
            while (stack.peek() != current) {
                depths[stack.pop()] = cycleLength;
            }
            stack.pop();
            while (!stack.isEmpty()) {
                depths[stack.pop()] = ++cycleLength;
            }
        }

        for (int i: depths) {
            maxDepth = Math.max(maxDepth, i);
        }

        return maxDepth;
    }

    /*
    Sample inputs:
    1.
    [4, 1, 2, 1]
    cycles: (don't count revisits)
    1 > 4 > 1
    2 > 1 > 4 > 1
    3 > 2 > 1 > 4 > 1
    4 > 1 > 4

    2. [4, 3, 5, 1, 2]
    1 > 4 > 1
    2 > 3 > 5 > 2
    3 > 5 > 2 > 3
    4 > 1 > 4
    5 > 2 > 3 > 5

    3. [2, 4, 2, 2, 3]
    1 > 2 > 4 > 2
    2 > 4 > 2
    3 > 2 > 4 > 2
    4 > 2 > 4
    5 > 3 > 2 > 4 > 2
    */


    // public static int getMaxVisitableWebpages(int N, int[] L) {
    //     // Write your code here
    //     List<Integer> queue = new ArrayList<>();
    //     HashMap<Integer, Integer> depths = new HashMap<>(); // map pages to depths
    //     int maxDepth = 0;
        
    //     for (int i = 1; i < N + 1; i++) {
    //       HashMap<Integer, Integer> seen = new HashMap<>();
    //       int current = i;
    //       int idx = 0;
    //       while (!seen.containsKey(current)) {
    //         seen.put(current, idx);
    //         queue.add(current);
    //         idx++;
    //         current = L[current - 1];
    //       }
    //       System.out.println(seen);
    //       System.out.println(queue);
    //       System.out.println(current);

    //       int cycleLength = queue.size();

    //       System.out.println(cycleLength);
          
    //       queue.clear();
    //       seen.clear();
    //     }
        
    //     return maxDepth;
    // }
}