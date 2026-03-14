class Solution {
    public String getHappyString(int n, int k) {

        List<String> all = new ArrayList<>();

        int total = (int)Math.pow(3, n);

        for(int i = 0; i < total; i++) {
            String s = "";

            int num = i;
            for(int j = 0; j < n; j++) {
                int r = num % 3;
                if(r == 0) s = "a" + s;
                if(r == 1) s = "b" + s;
                if(r == 2) s = "c" + s;
                num /= 3;
            }

            if(isHappy(s)) {
                all.add(s);
            }
        }

        Collections.sort(all);

        if(k > all.size()) return "";
        return all.get(k-1);
    }

    boolean isHappy(String s) {
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)==s.charAt(i+1))
                return false;
        }
        return true;
    }
}