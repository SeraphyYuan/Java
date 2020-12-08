class Solution {
    Set<String> set = new HashSet<>();
    public int numDistinctIslands(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    StringBuilder sb = new StringBuilder();
                    helper(grid, i, j, sb, "o" );
                    set.add(sb.toString());
                    System.out.print(sb.toString());
                    grid[i][j] = 0;
                }
            }
        }
        return set.size();
    }
    
    private void helper( int[][]grid, int i, int j, StringBuilder sb, String dir){
         if(i < 0 || i == grid.length || j < 0 || j == grid[i].length 
       || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        
        helper(grid, i-1, j, sb, "u");
        helper(grid, i+1, j, sb, "d");
        helper(grid, i, j-1, sb, "l");
        helper(grid, i, j+1, sb, "r");
        sb.append("b"); // back

    }
}