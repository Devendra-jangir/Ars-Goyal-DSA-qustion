
class Solution {
    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new HashSet<>());
    }

    private boolean canReach(int[] arr, int start, HashSet<Integer> visited) {
        if (start < 0 || start >= arr.length || visited.contains(start)) {
            return false;
        }
        
        if (arr[start] == 0) {
            return true;
        }
        
        visited.add(start);
        
        return canReach(arr, start + arr[start], visited) || canReach(arr, start - arr[start], visited);
    }
}
