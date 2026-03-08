import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        
       
        for (String s : nums) {
            set.add(s);
        }

        
        int total = (int) Math.pow(2, n); 
        for (int i = 0; i < total; i++) {
           
            String candidate = Integer.toBinaryString(i);
            
            
            while (candidate.length() < n) {
                candidate = "0" + candidate;
            }

          
            if (!set.contains(candidate)) {
                return candidate; 
            }
        }

        return ""; 
    }
}