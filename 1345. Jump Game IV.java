class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int m = arr.length;
        for(int i = 0; i < m; i++){
            if(i > 0 && i < m-1 && arr[i] == arr[i-1]  && arr[i] == arr[i+1]){
                continue;
            }
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int step = 0;
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        while(!q.isEmpty()){
            for (int size = q.size(); size > 0; size--) {
                int curr = q.poll();
                if(curr == m-1){
                    return step;
                }
                ArrayList<Integer> dirs  = map.getOrDefault(arr[curr], new ArrayList<>());
                dirs.add(curr+1);
                dirs.add(curr-1);
                for(int pos: dirs){
                    if(visited.contains(pos)){
                        continue;
                    }
                    if(pos >=0 && pos < m && !visited.contains(pos)){
                        q.add(pos);
                        visited.add(pos);
                    }
                }
            }
            step++;
        }
        return 0;
    }
}