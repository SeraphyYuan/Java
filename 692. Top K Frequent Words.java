class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String w: words){
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>((a,b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a)-map.get(b));
        for(String s: map.keySet()){
            heap.offer(s);
            if(heap.size() > k){
                heap.poll();
            }
        }
        List<String> res = new ArrayList();
        while(!heap.isEmpty()){
            res.add(0, heap.poll());
        }
        return res;
    }
}