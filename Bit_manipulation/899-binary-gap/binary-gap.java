class Solution {
    public int binaryGap(int n) {
        
        int lastIndex = -1;   
        int maxGap = 0;       
        int position = 0;     
        
        while (n > 0) {
            
            if ((n & 1) == 1) {
                
                if (lastIndex != -1) {
                    maxGap = Math.max(maxGap, position - lastIndex);
                }
                
                lastIndex = position;
            }
            
            n = n >> 1;  
            position++;
        }
        
        return maxGap;
    }
}