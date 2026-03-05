class Solution {
    public int minOperations(String s) {

        int changeStartWith0 = 0;
        int changeStartWith1 = 0;

        for(int i = 0; i < s.length(); i++) {

            if(i % 2 == 0) {
                if(s.charAt(i) != '0') {
                    changeStartWith0++;
                }
            } 
            else {
                if(s.charAt(i) != '1') {
                    changeStartWith0++;
                }
            }

            if(i % 2 == 0) {
                if(s.charAt(i) != '1') {
                    changeStartWith1++;
                }
            } 
            else {
                if(s.charAt(i) != '0') {
                    changeStartWith1++;
                }
            }
        }

        return Math.min(changeStartWith0, changeStartWith1);
    }
}