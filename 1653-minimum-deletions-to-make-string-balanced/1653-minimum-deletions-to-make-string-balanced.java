class Solution {
    public int minimumDeletions(String s) {
        int b_cnt = 0;
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                b_cnt++;
            } else if (b_cnt > 0) {
                b_cnt--;
                res++;
            }
        }
        return res;
    }
}