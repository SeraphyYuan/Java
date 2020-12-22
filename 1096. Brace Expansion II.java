class Solution {
     Set<String> set = new HashSet<>();
     StringBuilder sb = new StringBuilder();
     List<String> res = new ArrayList<>();
     Stack<String> stack = new Stack<>();
    public List<String> braceExpansionII(String expression) {
        stack.push(expression);
        dfs();
        Collections.sort(res);
        return res;
    }
    
    private void dfs(){
        while(!stack.isEmpty()){
            String s = stack.pop();
            if(s.indexOf("{") == -1){
                if(!set.contains(s)){
                    res.add(s);
                    set.add(s);
                }
                continue;
            }
            int i = 0;
            int l = 0;
            int r = 0;
            while(s.charAt(i) != '}'){
                if(s.charAt(i++) == '{'){
                    l = i -1;
                }
            }
            r = i;
            String before = s.substring(0, l);
            String after = s.substring(r+1, s.length());
            String str[] = s.substring(l+1, r).split(",");
            
            for(String s1: str){
                sb.setLength(0);
                stack.push(sb.append(before).append(s1).append(after).toString());
            }
        }
    }
}