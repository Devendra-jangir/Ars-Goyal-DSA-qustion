class Solution {
    
    public int nthUglyNumber(int n) {
        int i2 = 0; 
        int i3 = 0;
        int i5 = 0;
        List<Integer> ls = new ArrayList<>();
        ls.add(1);  // The first ugly number is 1
        
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;
        
        for (int i = 1; i < n; i++) {
            int number = Math.min(next2, Math.min(next3, next5));
            ls.add(number);
            
            if (number == next2) {
                i2++;
                next2 = ls.get(i2) * 2;
            }
            if (number == next3) {
                i3++;
                next3 = ls.get(i3) * 3;
            }
            if (number == next5) {
                i5++;
                next5 = ls.get(i5) * 5;
            }
        }
        
        return ls.get(n - 1);
    }
}