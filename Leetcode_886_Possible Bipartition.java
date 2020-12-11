class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N+1];
        List<List<Integer>> list = new ArrayList<>(N+1);
        for (int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        for(int[] d: dislikes){
            list.get(d[0]).add(d[1]);
            list.get(d[1]).add(d[0]);
        }
        //corlor: 0 -> not colored, 1->red, -1->blue
        for (int i = 1; i<=N; i++){
            if(color[i] == 0){
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                 while (!q.isEmpty()){
                    int curr = q.poll();
                    for(int neibhor: list.get(curr)){
                        if(color[neibhor] == 0){
                            color[neibhor] = -color[curr];
                            q.add(neibhor);
                        }
                        else {
                            if(color[neibhor] == color[curr]){
                                return false;
                            }
                            else {
                                continue;
                            }
                        }
                    }
                }
            }
            
        }
        return true;
    }
}