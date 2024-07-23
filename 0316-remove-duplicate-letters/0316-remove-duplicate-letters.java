class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            lastIndex[ch-'a'] = i;
        }
        
        Stack<Character>st = new Stack<>();
        boolean[] lastseen = new boolean[26];
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(lastseen[ch-'a']){
                continue;
            }
            
            while(!st.isEmpty() && st.peek()>ch && i<lastIndex[st.peek()-'a']){
                lastseen[st.peek() - 'a']= false;
                st.pop();
            }
            st.push(ch);
            lastseen[ch-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        return sb.toString();
    }
}