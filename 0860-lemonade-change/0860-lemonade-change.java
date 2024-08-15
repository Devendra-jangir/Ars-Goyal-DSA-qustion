class Solution {
    public boolean lemonadeChange(int[] bills) {
        int s5 = 0;
        int s10 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                s5++;
            } else if (bills[i] == 10) {
                if (s5 == 0) {
                    return false;
                }
                s5--;
                s10++;
            } else { 
                if (s10 > 0 && s5 > 0) {
                    s10--;
                    s5--;
                } else if (s5 >= 3) {
                    s5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
