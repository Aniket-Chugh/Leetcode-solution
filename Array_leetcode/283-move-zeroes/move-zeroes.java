class Solution {


    
 
  public static void swap(int[] arr , int left , int right){
    int temp = arr[left];
 arr[left] = arr[right];
    arr[right] = temp;
  }



    public void moveZeroes(int[] nums) {
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
        if (nums[right] != 0) {
            if (left != right) {
                swap(nums , left , right);
            }
            left++;
        }
    }
}

}