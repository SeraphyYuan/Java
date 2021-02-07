class Solution {
      static Map<Character, String> map = new HashMap() {
        {
            put('0', "");
            put('1', "");
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
       
        StringBuilder sb = new StringBuilder();
        dfs(digits, map, sb, 0 , res);
        return res;
    }
    
    public void dfs(String digits, Map<Character, String>map, StringBuilder sb, int index, List<String> res) {
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        String options = map.get(c);
        for(int i = 0; i<options.length(); i++){
            sb.append(options.charAt(i));
            dfs(digits, map, sb, index+1, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}