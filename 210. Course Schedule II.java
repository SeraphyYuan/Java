class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int required = prerequisites[i][1];
            graph.get(course).add(required);
        }
        ArrayList<Integer> order = new ArrayList<>();
        int[] visited = new int[numCourses];
        boolean findCircle = false;
        for (int i =0;i < numCourses; i++){
            if(dfs(i, graph, visited, order)){
                findCircle = true;
                break;
            }
        }
        if(findCircle){
            return new int[0];
        }
        else {
            int [] result = new int[order.size()];
            for (int i = 0; i < order.size(); i++){
                result[i] = order.get(i);
            }
            return result;
        }
    }
    
    private boolean dfs(int i, ArrayList<ArrayList<Integer>> graph, int[] visited, ArrayList<Integer> order){
        if(visited[i] == 1) {
            return true;
        }
        if(visited[i] == 2) {
            return false;
        }
        visited[i] = 1;
        for(int next: graph.get(i)) {
            if(dfs(next, graph, visited, order)){
                return true;
            }
        }
        order.add(i);
        visited[i] = 2 ;
        return false;
    }
}