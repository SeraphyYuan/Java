class Leetcode_464 {
    private static byte[] memo;
    public static void main(String[] args) {
        int maxChoosableInteger = 10;
        int target = 11;
        boolean result = canIWin(maxChoosableInteger, target);
        System.out.println("Result = "+ result);
    }
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)* maxChoosableInteger/ 2;
        if(sum < desiredTotal){
            return false;
        }
        if(desiredTotal <= 0){
            return true;
        }
        memo = new byte[1 << maxChoosableInteger];
        return helper(maxChoosableInteger, desiredTotal, 0);
        
    }
    
    private static boolean helper(int M, int T, int state){
        if(T <= 0){
            return false;
        }
        if(memo[state] != 0){
            return memo[state] == 1;
        }
        for (int i=0; i< M; ++i){
            if((state&(1<<i)) >0){
                continue;
            }
            if(!helper(M, T-(i+1), state|(1<<i))){
                memo[state] =1;
                return true;
            }
        }
        memo[state] = -1;
        return false;
    }
}