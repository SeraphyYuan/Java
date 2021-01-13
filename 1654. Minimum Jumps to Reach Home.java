class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<String> visited = new HashSet<>();
        Set<Integer> forbid = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1,b1)->(a1[0]-b1[0]));
        pq.add(new int[]{0,0,0}); // step, index, direction : 0->right, -1->left;
        int maxLimit = 2000 +2 * b;
        for(int i: forbidden){
            maxLimit = Math.max(maxLimit, i+b*2);
            forbid.add(i);
        }
        while(!pq.isEmpty()){            
            int[] current = pq.poll();
            int currentStep = current[0];
            int currentIndex = current[1];
            int dir = current[2];
            if(currentIndex == x){
                return currentStep;
            }
            //Jump forward
            int nextIndex = currentIndex + a;
            String key = nextIndex+","+0;
            if(nextIndex < maxLimit && !forbid.contains(nextIndex) && !visited.contains(key)){
                visited.add(key);
                pq.offer(new int[]{currentStep+1, nextIndex, 0});
            }
            //Jump backward
            nextIndex = currentIndex - b;
            key = nextIndex + "," + "1";
            if(nextIndex >= 0 && !forbid.contains(nextIndex) && !visited.contains(key) && dir != 1) {
                visited.add(key);
                pq.offer(new int[]{currentStep+1, nextIndex, 1});
            }   
        }
        return -1;
    }
}