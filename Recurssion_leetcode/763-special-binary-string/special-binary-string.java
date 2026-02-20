import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        if(s.length() <= 2){
            return s;
        }
List<String> ans = new ArrayList<>();
       int count = 0;
    int start = 0;
    for(int i=0;i< s.length() ;i++){
        if(s.charAt(i) == '1'){
            count++;
        }
        else {
            count--;
        }

if(count == 0){
    String inner = s.substring(start + 1, i);
    String processed = "1" + makeLargestSpecial(inner) + "0";

    ans.add(processed);
    start = i+1;
}

    }
    Collections.sort(ans,Collections.reverseOrder());

StringBuilder result = new StringBuilder();

for (int i= 0; i < ans.size(); i++) {
    String str = ans.get(i);
    result.append(str);
}
return result.toString();
}
    }

    