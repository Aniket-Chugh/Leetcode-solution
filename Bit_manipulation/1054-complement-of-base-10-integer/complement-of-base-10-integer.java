class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder ans = new StringBuilder();
        String binary = Integer.toBinaryString(n);
        for(int i=0;i<binary.length();i++){
            if (binary.charAt(i) == '0') ans.append('1');
            else ans.append('0');
        }
        
        int res = Integer.parseInt(ans.toString(), 2);
        return res;
    }
}