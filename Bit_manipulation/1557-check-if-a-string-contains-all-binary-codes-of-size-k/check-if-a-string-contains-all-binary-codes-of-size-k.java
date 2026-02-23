import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i <= s.length() - k; i++) {
            
            String part = s.substring(i, i + k);
            set.add(part);
        }
        
        int total = (int)Math.pow(2, k);
        
        return set.size() == total;
    }
}