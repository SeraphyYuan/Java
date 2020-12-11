import java.util.List;
import java.util.ArrayList;

class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int M = 1000000007;
        int n = hats.size();
        /*Build a hat-person map, each hat could be weared by which person*/
        List<Integer>[] hatMap = new List[40];
        for(int i=0; i<40; i++){
            hatMap[i] = new ArrayList<>();
        }
        for(int i=0; i<hats.size(); i++){
            for(int hat: hats.get(i)){
                hatMap[hat-1].add(i); //0-th begin
            }
        }
        
        
       int[][] dp = new int[41][1<<n];
        dp[0][0] = 1;
        for(int hat = 0; hat< 40; hat++){
            for(int state =0; state<(1<<n); state++){
                dp[hat+1][state] = dp[hat][state];
                for(int person: hatMap[hat]){
                    int index = 1<<person;
                    if((index & state) >0 ){
                        dp[hat+1][state] += dp[hat][state ^ index];
                        dp[hat+1][state] %= M;
                    }
                }
            }
        }
        return dp[40][(1<<n)-1];
    }
}