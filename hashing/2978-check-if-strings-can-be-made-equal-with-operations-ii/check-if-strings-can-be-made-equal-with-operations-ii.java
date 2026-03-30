import java.util.*;

public class Solution {
    public boolean checkStrings(String s1, String s2) {
        
        HashMap<Character, Integer> evenMap = new HashMap<>();
        HashMap<Character, Integer> oddMap = new HashMap<>();
        
        
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            
            if (i % 2 == 0) {
                evenMap.put(ch, evenMap.getOrDefault(ch, 0) + 1);
            } else {
                oddMap.put(ch, oddMap.getOrDefault(ch, 0) + 1);
            }
        }
        
       
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            
            if (i % 2 == 0) {
                evenMap.put(ch, evenMap.getOrDefault(ch, 0) - 1);
            } else {
                oddMap.put(ch, oddMap.getOrDefault(ch, 0) - 1);
            }
        }
        
        
        for (int val : evenMap.values()) {
            if (val != 0) return false;
        }
        
        for (int val : oddMap.values()) {
            if (val != 0) return false;
        }
        
        return true;
    }
}