class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int pos = 0; pos < n; pos++) {
            leftMost[pos] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[pos]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftMost[pos] = stack.peek();
            }
            stack.push(pos);
        }
        stack.clear();

        for (int pos = n - 1; pos >= 0; pos--) {
            rightMost[pos] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[pos]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightMost[pos] = stack.peek();
            }
            stack.push(pos);
        }

        int maxArea = 0;
        for (int pos = 0; pos < n; pos++) {
            leftMost[pos] += 1;
            rightMost[pos] -= 1;
            maxArea = Math.max(maxArea, heights[pos] * (rightMost[pos] - leftMost[pos] + 1));
        }
        return maxArea;
    }
}
