class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir = {{0,1}, {-1, 0}, {0, -1}, {1, 0}};
        int facing = 0;
        int x = 0; 
        int y = 0;
        //There is two situation if robort will be bounded in Circle
        // 1. if return to origin point which is (0,0)
        // 2. after a circle if it is not facing north
        for(int i=0; i<instructions.length(); i++){
            char ins = instructions.charAt(i);
            if(ins == 'L'){
                facing = (facing + 1) % 4;   
            }
            else if(ins == 'R') {
                facing =  (facing + 3)%4;
            }
            else {
                x = x + dir[facing][0];
                y = y + dir[facing][1];
            }
        }
        return (x==0 && y==0) || facing != 0;
    }
}