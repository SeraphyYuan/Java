class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadset = new HashSet<>();
        for(String s: deadends){
            deadset.add(s);
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add("0000");
        visited.add("0000");
        int steps = 0;
        while(!q.isEmpty()){
            int len = q.size();
            while(len > 0){
                String curr = q.poll();
                if(curr.equals(target)){
                    return steps;
                }
                if(deadset.contains(curr)){
                    len--;
                    continue;
                }
                StringBuilder sb = new StringBuilder(curr);
                for(int i = 0; i <4; i++){
                    char c = curr.charAt(i);
                    String s1 = sb.substring(0,i) + (c == '9' ? 0: c-'0'+1) + sb.substring(i+1);
                    String s2 = sb.substring(0,i) + (c == '0' ? 9: c-'0'-1) + sb.substring(i+1);
                    if(!visited.contains(s1) && !deadset.contains(s1)){
                        q.add(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !deadset.contains(s2)){
                        q.add(s2);
                        visited.add(s2);
                    }
                }
                len--;
            }
            steps++;
        }
        return -1;
    }
}