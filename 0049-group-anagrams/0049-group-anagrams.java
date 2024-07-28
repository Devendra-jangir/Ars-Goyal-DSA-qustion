class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>>ans= new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String ns = new String(ch);
            if(!map.containsKey(ns)){
                map.put(ns, new ArrayList<>());
            }
            
                 map.get(ns).add(s);
        }
        ans.addAll(map.values());
            return ans;
    }
}