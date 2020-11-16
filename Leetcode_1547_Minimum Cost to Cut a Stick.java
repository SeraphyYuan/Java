class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<Integer>();
        for (int cut : cuts) {
            list.add(cut);
        }
        list.add(0);
        list.add(n);
        Collections.sort(list);
        int length = list.size();
        int[][] dp = new int[length][length];
        for(int range = 2; range < length; range++){    //available range
            for(int l=0; l+range<length; l++) {    //left side cutting point
                int r = l + range;                  //right side cutting point
                dp[l][r] = Integer.MAX_VALUE;
                for(int cutPoint = l+1; cutPoint<r; cutPoint++)
                dp[l][r] = Math.min(dp[l][r], dp[l][cutPoint]+dp[cutPoint][r]+(list.get(r)-list.get(l)));
            }
        }
        return dp[0][length-1];
    }
}