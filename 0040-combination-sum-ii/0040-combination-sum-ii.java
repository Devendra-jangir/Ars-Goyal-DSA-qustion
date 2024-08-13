

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        Arrays.sort(candidates);
        solver(candidates, 0, ans, temp, target);
        return ans;
    }

    public void solver(int[] candidates, int idx, List<List<Integer>> ans, List<Integer> temp, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            // Skip duplicates
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            solver(candidates, i + 1, ans, temp, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
