class Solution {
    public String simplifyPath(String path) {
        Stack<String> dequeue = new Stack<>();

        Set<String> skipSet = new HashSet<>(Arrays.asList(".", "..",""));
        for(String dir: path.split("/")){
            if(dir.equals("..") && !dequeue.isEmpty()){
                dequeue.pop();
            }
            else if(!skipSet.contains(dir)){
                dequeue.push(dir);
            }
        }
        String res = "";
        
        for (String dir : dequeue){
            res += "/" + dir;
        } 
        return res.isEmpty()? "/": res;
    }
}