class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(arr[curr] == 0){
                return true;
            }
            if(arr[curr] < 0){
                continue;
            }
            
            if(curr + arr[curr] < n){
                q.add(curr+arr[curr]);
            }
            if(curr-arr[curr] >= 0){
                q.add(curr-arr[curr]);
            }
            arr[curr] = -arr[curr];
        }
        return false;
        
         
    }
}

//Second Time code
class Solution {
    public boolean canReach(int[] arr, int start) {
        Deque<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(arr[curr] == 0){
                return true;
            }
            int left = curr - arr[curr];
            int right = curr + arr[curr];
            int len = arr.length;
            if(left >= 0 && left < len && !visited.contains(left))  {
                q.add(left);
                visited.add(left);
            }
            if(right >= 0 && right < len && !visited.contains(right))  {
                q.add(right);
                visited.add(right);
            }
        }
        return false;
    }
}