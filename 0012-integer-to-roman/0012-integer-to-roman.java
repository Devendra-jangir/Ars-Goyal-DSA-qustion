import java.util.ArrayList;

class Solution {
    class Pairs {
        String roman; // Change to String to handle subtractive combinations
        int val;
        public Pairs(String roman, int val) {
            this.roman = roman;
            this.val = val;
        }
    }

    public String intToRoman(int num) {
        ArrayList<Pairs> arr = new ArrayList<>();
        arr.add(new Pairs("M", 1000));
        arr.add(new Pairs("CM", 900)); // Subtractive combination for 900
        arr.add(new Pairs("D", 500));
        arr.add(new Pairs("CD", 400)); // Subtractive combination for 400
        arr.add(new Pairs("C", 100));
        arr.add(new Pairs("XC", 90));  // Subtractive combination for 90
        arr.add(new Pairs("L", 50));
        arr.add(new Pairs("XL", 40));  // Subtractive combination for 40
        arr.add(new Pairs("X", 10));
        arr.add(new Pairs("IX", 9));   // Subtractive combination for 9
        arr.add(new Pairs("V", 5));
        arr.add(new Pairs("IV", 4));   // Subtractive combination for 4
        arr.add(new Pairs("I", 1));
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.size(); i++) {
            Pairs curr = arr.get(i);
            while (num >= curr.val) {
                sb.append(curr.roman);
                num -= curr.val;
            }
        }
        
        return sb.toString();
    }
}
