class Solution {
    public boolean judgeCircle(String moves) {
       int i=0;
       int j=0;
       int size = moves.length();
       for(int k=0; k<size;k++){
        if(moves.charAt(k) == 'U') {
            i=i-1;
            continue;
        }
        if(moves.charAt(k) == 'D') {
            i=i+1;
             continue;
        }
        if(moves.charAt(k) == 'R') {
            j=j+1;
             continue;
        }
        if(moves.charAt(k) == 'L') {
            j=j-1;
             continue;
        }
        
       }
System.out.print(i + " " + j);
       if(i == 0 && j==0){
        return true;
       }

       return false;

           }
}