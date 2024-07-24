class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<haystack.length(); i++){
            if(haystack.charAt(i) != needle.charAt(0)){
                continue;
            }
            else{
                if(i+needle.length()> haystack.length()){
                    break;
                }
                String sb = haystack.substring(i,i+needle.length());
                if(sb.equals(needle)){
                    min = Math.min(i, min);
                    
               }
            }
        }
        return min == Integer.MAX_VALUE?-1: min;
    }
}