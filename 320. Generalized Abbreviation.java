class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }
    
    public void helper(List<String> res, String word, int index, String currStr, int count){
        if(index == word.length()){
            if(count > 0){
                currStr += count;
            }
            res.add(currStr);
        }
        else {
            helper(res, word, index+1, currStr, count+1);       //abre curr character;
            helper(res, word, index+1, currStr + (count > 0 ? count: "")+word.charAt(index), 0);
        }
       
        
    }
}