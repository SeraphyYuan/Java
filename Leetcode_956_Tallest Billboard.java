import java.util.HashMap;
class Leetcode_956 {
    public static void main(String[] args) {
        int [] rods = {1,2,3,6};
        int reuslt = tallestBillboard(rods);
        System.out.println("Result = "+ reuslt);
    }
    public static int tallestBillboard(int[] rods) {
        HashMap<Integer, Integer> dp = new HashMap<>(), cur;
        dp.put(0,0);
        for(int x: rods){
            cur = new HashMap<>(dp);
            for(int d: cur.keySet()){
                dp.put(d + x, Math.max(cur.get(d), dp.getOrDefault(x + d, 0)));
                dp.put(Math.abs(d - x), Math.max(cur.get(d) + Math.min(d, x), dp.getOrDefault(Math.abs(d - x), 0)));
            }    
        }
        return dp.get(0);
        
       
    }
}