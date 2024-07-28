// class Solution {
//     public String reverseWords(String s) {
//         String[] arr = s.trim().split("\\s+");
        
//         int i = 0;
//         int j = arr.length - 1;
        
//         while (i <= j) {
//             String temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//             i++;
//             j--;
//         }
        
//         StringBuilder ans = new StringBuilder();
        
//         for (int c = 0; c < arr.length; c++) {
//             ans.append(arr[c]);
//             if (c < arr.length - 1) {
//                 ans.append(" ");
//             }
//         }
        
//         return ans.toString();
//     }
// }

class Solution {
    public String reverseWords(String s) {
        
        int i=s.length()-1;
        String ans="";

        while(i>=0){
            //ignore the trailing space of String
            while(i>=0 && s.charAt(i)==' ') i--;
            
            // handle the leading space of String
            if(i<0) break;

            int j=i;
            
            while(i>=0 && s.charAt(i)!=' ') i--;

            if(ans.isEmpty()){
                ans=ans.concat(s.substring(i+1,j+1));
            }else{
                ans=ans.concat(' '+s.substring(i+1,j+1));
            }
        }

        return ans;
    }
}
