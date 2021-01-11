class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        if(words==null || words.length==0) return "";

        //Build Graph
        for (String s: words){
            for(Character c: s.toCharArray()){
                indegree.put(c, 0);
            }
        }
        for (int i = 0; i< words.length - 1; i++){
            String curr = words[i];
            String next = words[i+1];
             if (curr.length() > next.length() && curr.startsWith(next)) {
                return "";
            }
            int len = Math.min(curr.length(), next.length());
            for (int j =0; j < len ; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(c1)){
                        set = map.get(c1);
                    }
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        
        //BFS
        Queue<Character> queue = new LinkedList<>();
        String result = "";
        for(char i: indegree.keySet()){
            if(indegree.get(i) == 0){
                queue.offer(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            char c = queue.poll();
            result += c;
            if(map.containsKey(c)){
                for (char next: map.get(c)){
                    indegree.put(next, indegree.get(next)-1);
                    if(indegree.get(next) == 0){
                        queue.offer(next);
                    }
                }
            }
            
        }
        if(result.length() != indegree.size()){
            return "";
        }
        return result;
        
    }
}