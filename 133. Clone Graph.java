class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val, new ArrayList<Node>()));
        while(!q.isEmpty()){
            Node currNode = q.poll();
            for(Node neig: currNode.neighbors){
                if(!map.containsKey(neig)){
                    map.put(neig, new Node(neig.val, new ArrayList<Node>()));
                    q.add(neig);
                }
               map.get(currNode).neighbors.add(map.get(neig));
            }
        }
        return map.get(node);
    }
}