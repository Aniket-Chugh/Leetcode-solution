class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return solve(0, candidates, target);
    }

    private List<List<Integer>> solve(int index, int[] arr, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        if (target == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        if (index == arr.length || target < 0) {
            return result;
        }

        if (arr[index] <= target) {
            List<List<Integer>> take = solve(index, arr, target - arr[index]);

            for (List<Integer> list : take) {
                list.add(arr[index]);   
                result.add(list);
            }
        }

        List<List<Integer>> skip = solve(index + 1, arr, target);
        result.addAll(skip);

        return result;
    }
}
