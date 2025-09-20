class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int answer = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = minHeight * width;
            answer = Math.max(answer, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}
