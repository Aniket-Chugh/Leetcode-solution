import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int ans = Integer.MAX_VALUE;
        
        // Step 2: process each value
        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size < 3) continue;
            
            // Step 3: check consecutive triples
            for (int i = 0; i <= size - 3; i++) {
                int first = list.get(i);
                int third = list.get(i + 2);
                
                int dist = 2 * (third - first);
                ans = Math.min(ans, dist);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}