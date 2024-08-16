class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);

            // Compare with min and max from the first array
            result = Math.max(result, Math.abs(currentMax - min));
            result = Math.max(result, Math.abs(max - currentMin));

            // Update min and max to include the current array
            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }

        return result;
    }
}
