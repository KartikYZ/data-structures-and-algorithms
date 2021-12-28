package problems;

import java.util.*;

public class ArraySums {
    public static int[] twoSum(int[] nums, int target) throws Exception {
        int[] idxs = {-1, -1};
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) { 
            int key = target - nums[i];
            if (seen.containsKey(key)) {
                idxs[0] = seen.get(key);
                idxs[1] = i;
            } else {
                seen.put(nums[i], i);
            }
        }

        return idxs;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> seen = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> a = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    if (!seen.contains(a)) {
                        ans.add(a);    
                    }
                    seen.add(a);
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        int count = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);
        for (int i: nums) {
            if (seen.containsKey(i - k)) {
                count += seen.get(i - k); 
            }
            seen.put(i, seen.getOrDefault(i, 0) + 1);
        }
        
        return count;
    }

    public boolean isSubarraySumDivisibleByK(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (nums[i] % k == 0) {
                return true;
            }
        }
        
        HashMap<Integer, Integer> rems = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = nums[i] % k;
            
            if (rems.containsKey(rem)) {
                if (i - rems.get(rem) >= 2) {
                    return true;
                }
            } else {
                rems.put(rem, i);
            }
        }
        
        return false;
    }

}