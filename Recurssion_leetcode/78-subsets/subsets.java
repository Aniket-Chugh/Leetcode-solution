class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void findSubsets(int[] nums, int index,
                            List<Integer> current,
                            List<List<Integer>> result) {

        // If we reached end of array
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        findSubsets(nums, index + 1, current, result);

        current.remove(current.size() - 1);

        findSubsets(nums, index + 1, current, result);
    }
}
