class Solution {
    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] boxes = new boolean[9][10];
    public void solveSudoku(char[][] board) {
        for(int i=0; i < 9 ; i++){
            for(int j=0; j<9; j++){
                char c = board[i][j];
                if(c != '.'){
                    int n = c-'0';
                    row[i][n] = true;
                    col[j][n] = true;
                    int bx = i/3;
                    int by = j/3;
                    int boxIndex = bx *3 + by;
                    boxes[boxIndex][n] = true;
                }
            }
        }
        dfs(0, 0, board);
    }
    
    public boolean dfs(int x, int y, char[][]board){
        if(y == 9){
            return true;
        }
        int nx = (x+1) % 9;
        int ny = (nx == 0)? y+1: y;
        if(board[x][y] != '.'){
            return dfs(nx, ny, board);
        }
        for(char i ='1'; i<= '9'; i++){
            int bx = x /3;
            int by = y /3;
            int boxIndex = bx *3 + by;
            int numI = i - '0';
            if(!row[x][numI] && !col[y][numI] && !boxes[boxIndex][numI]) {
                row[x][numI] = true;
                col[y][numI] = true;
                boxes[boxIndex][numI] = true;
                board[x][y] = i;
                if(dfs(nx, ny, board)){
                    return true;
                }
                row[x][numI] =false;
                col[y][numI] = false;
                boxes[boxIndex][numI] = false;
                board[x][y] = '.';
            }
        }
        return false;
        
    }
}