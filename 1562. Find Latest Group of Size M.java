class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if(m == n){
            return n;
        }
        TreeSet<int[]> set = new TreeSet<>((a,b)->a[0]-b[0]);
        //initial the wall range from index 1 to the end
        //putting the wall: start from the end
        set.add(new int[]{1, n});
        for (int i = n -1; i>=0; i--){
            int[] curr = set.floor(new int[]{arr[i]});
            System.out.println(Arrays.toString(curr) + " " + arr[i]);
            if(curr == null || arr[i] > curr[1]) {
                continue;
            }
            set.remove(curr);
            if(arr[i] - curr[0] == m || curr[1] - arr[i] == m){
                return i;
            }
            if(arr[i] - curr[0] > m) {
                set.add(new int[]{curr[0], arr[i]-1});
            }
            if(curr[1] - arr[i] > m){
                set.add(new int[]{arr[i]+1, curr[1]});
            }
        }
        return -1;
    }
}