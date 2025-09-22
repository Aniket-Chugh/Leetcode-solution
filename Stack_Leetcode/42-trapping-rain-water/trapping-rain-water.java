class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>(); 
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); 
                if (stack.isEmpty()) {
                    break; 
                }
                int distance = i - stack.peek() - 1; 
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                water += distance * bounded_height;
            }
            stack.push(i);
        }

        return water;
    }
}