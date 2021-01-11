class Solution {
     public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
         Map<Integer, List<Integer>> map = new HashMap<>();
         Map<Integer, Integer> indegree = new HashMap<>();
         
         // add nodes
         for(List<Integer> list: seqs) {
             for (int i = 0; i < list.size(); i++){
                 indegree.putIfAbsent(list.get
(i), 0);
                 map.putIfAbsent(list.get(i), new ArrayList<>());
             }
         }
         
         if(indegree.size() != org.length) return false; //number not matching
         
         // add edges
         for(List<Integer> list: seqs){
             for (int i = 0; i < list.size()-1; i++){
                 if(!map.get(list.get(i)).contains(i+1)){
                     map.get(list.get(i)).add(list.get(i+1)); // add relation ship
                     indegree.put(list.get(i+1), indegree.get(list.get(i+1))+1);
                 }
             }
         }
         return topSort(map, indegree, org);
     }
    
    private boolean topSort(Map<Integer, List<Integer>> map, Map<Integer, Integer> indegree, int[] org) {
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[org.length];
        
        for (int i: indegree.keySet()){
            if(indegree.get(i) == 0) {
                queue.offer(i);
            }
        }
        
        int index = 0;
        while(!queue.isEmpty()) {
            if(queue.size() > 1){ //if queue has 2 numbers that means there are 2 possible way, so return false
                return false;
            }
            int num = queue.poll();
            res[index++] = num;
            for (int i : map.get(num)){
                indegree.put(i, indegree.get(i)-1);
                if(indegree.get(i) == 0){
                    queue.offer(i);
                }
            }
        }
        for (int i = 0; i < org.length; i++){
            if(res[i] != org[i]) return false;
        }
        return true;
    }
}