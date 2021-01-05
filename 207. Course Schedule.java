class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int required = prerequisites[i][1];
            graph.get(course).add(required);
        }
        
        //State: 0: unknow; 1: visiting; 2: visited
        int[] visited = new int[numCourses];
        for (int i = 0; i< numCourses; i++){
            if(dfs(i, graph, visited)){
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int i, ArrayList<ArrayList<Integer>> graph, int[] visited){
        if(visited[i] == 1) {
            return true;
        }
        if(visited[i] ==2) {
            return false;
        }
        visited[i] = 1;
        for (int next: graph.get(i)){
           if(dfs(next, graph, visited)){
               return true;
           }
        }
        visited[i] = 2;
        return false;
    }
}