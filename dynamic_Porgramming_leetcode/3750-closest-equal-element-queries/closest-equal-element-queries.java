import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size == 1) continue;
            
            for (int i = 0; i < size; i++) {
                int curr = list.get(i);
                int prev = list.get((i - 1 + size) % size);
                int next = list.get((i + 1) % size);
                
                int distPrev = Math.abs(curr - prev);
                distPrev = Math.min(distPrev, n - distPrev);
                
                int distNext = Math.abs(curr - next);
                distNext = Math.min(distNext, n - distNext);
                
                res[curr] = Math.min(distPrev, distNext);
            }
        }
        
       
        List<Integer> answer = new ArrayList<>();
        for (int q : queries) {
            answer.add(res[q]);
        }
        
        return answer;
    }
}