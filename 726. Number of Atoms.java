class Solution {
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        TreeMap<String, Integer> currMap = new TreeMap<>();
        int len = formula.length();
        for(int i=0; i < len;){
            char c = formula.charAt(i);
            if(c == '('){
                stack.push(currMap);
                currMap = new TreeMap();
                i++;
            }
            else if(c == ')'){
                TreeMap<String, Integer> tempMap = currMap;
                currMap = stack.pop();
                i++;
                int isStart = i;
                int quantity = 1;
                while(i < len && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                if(isStart < i){
                    quantity = Integer.parseInt(formula.substring(isStart, i));
                }
                for(String name: tempMap.keySet()){
                    currMap.put(name, currMap.getOrDefault(name, 0) + tempMap.get(name) * quantity);
                }
            }
            else {
                int isStart = i;
                i++;
                while(i< len && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String name = formula.substring(isStart, i);
                isStart = i;
                int quantity = 1;
                while(i < len && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                if(isStart < i){
                    quantity = Integer.parseInt(formula.substring(isStart, i));
                }
                currMap.put(name, currMap.getOrDefault(name, 0) + quantity);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String name: currMap.keySet()){
            sb.append(name);
            int quantity = currMap.get(name);
            if(quantity > 1){
                sb.append(quantity);
            }
        }
        return sb.toString();
    }
}