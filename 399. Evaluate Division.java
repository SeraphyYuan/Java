import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        /** Build Graph**/
        for (int i = 0; i<equations.size(); i++){
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];
            if(!graph.containsKey(dividend)){
                graph.put(dividend, new HashMap<String, Double>());
            }
            if(!graph.containsKey(divisor)){
                graph.put(divisor,  new HashMap<String, Double>());
            }
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1/quotient);
        }
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> equation = queries.get(i);
            String divident = equation.get(0);
            String divisor = equation.get(1);
            if(divident == divisor){
                result[i] = 1.0;
            }
            else if(!graph.containsKey(divident) || !graph.containsKey(divisor)){
                result[i] = -1.0;
            }
            else {
                Set<String> visited = new HashSet<>();
                result[i] = DFS(graph, divident, divisor, 1.0, visited);
            }
        }
        return result;
    }

    private double DFS(HashMap<String, HashMap<String, Double>> graph, String current, String target, double multiply, Set<String>visited){
        visited.add(current);
        double res = -1.0;
        
        HashMap<String, Double> neighbours = graph.get(current);
        if(neighbours.containsKey(target)){
            res = multiply * neighbours.get(target);
        }
        else {
            for (Map.Entry<String, Double> entry: neighbours.entrySet()){
                String next = entry.getKey();
                if(visited.contains(next)){
                    continue;
                }
                else {
                    double newMultiply = multiply * entry.getValue();
                    res = DFS(graph, next, target, newMultiply, visited);
                }
                if(res != -1.0){
                        break;
                }
            }
        }
        visited.remove(current);
        return res;

    }
}
// @lc code=end

