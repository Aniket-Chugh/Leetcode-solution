import java.util.HashMap;

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if(map.containsKey(num)) {

                int oldIndex = map.get(num);

                int distance = i - oldIndex;

                if(distance <= k) {
                    return true;
                }
            }

            map.put(num, i);
        }

        return false;
    }
}