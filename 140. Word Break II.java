class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(wordDict.contains(s)){
            res.add(s);
        }
        for(int i= 1; i < s.length(); i++){
            String str = s.substring(i);
            if(wordDict.contains(str)){
                List<String> currRes = wordBreak(s.substring(0, i), wordDict);
                for(String next: currRes){
                    res.add(next + " " + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}