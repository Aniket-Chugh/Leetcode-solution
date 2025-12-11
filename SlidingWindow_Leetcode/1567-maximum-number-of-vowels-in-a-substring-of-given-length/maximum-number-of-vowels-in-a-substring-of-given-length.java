class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels;
        int count = 0;

        for(int i=0;i<k;i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'   ){
                count = count +1;

            }
        }
int MaxCount = count;

for(int i=k;i<s.length();i++){
     if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'   ){
                count = count +1;

            }

             if(s.charAt(i-k) == 'a' || s.charAt(i-k) == 'e' || s.charAt(i-k) == 'i' || s.charAt(i-k) == 'o' || s.charAt(i-k) == 'u'   ){
                               count--;


            }

            MaxCount = Math.max(MaxCount , count);
}

return MaxCount;


    }
}