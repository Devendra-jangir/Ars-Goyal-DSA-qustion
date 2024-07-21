import java.util.*;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        Deque<int[]> deque = new LinkedList<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            
            // Remove points from the front of the deque if they are out of range
            while (!deque.isEmpty() && x - deque.peekFirst()[0] > k) {
                deque.pollFirst();
            }
            
            // Calculate the value for the current point with the front of the deque
            if (!deque.isEmpty()) {
                max = Math.max(max, y + x + deque.peekFirst()[1] - deque.peekFirst()[0]);
            }
            
            // Maintain the deque in decreasing order of y - x
            while (!deque.isEmpty() && y - x >= deque.peekLast()[1] - deque.peekLast()[0]) {
                deque.pollLast();
            }
            
            // Add the current point to the deque
            deque.offerLast(new int[] {x, y});
        }

        return max;
    }
}
