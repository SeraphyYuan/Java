class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        if(!isLeaf(root)){
            res.add(root.val);
        }
        TreeNode t = root.left;
        while(t != null){
            if(!isLeaf(t)){
                res.add(t.val);
            }
            if(t.left != null){
                t= t.left;
            }
            else {
                t = t.right;
            }
        }
        addLeaves(res, root);
        t = root.right;
        Stack<Integer> s = new Stack<>();
        while(t != null){
            if(!isLeaf(t)){
                s.push(t.val);
            }
            if(t.right != null){
                t = t.right;
            }
            else {
                t = t.left;
            }
        }
        while(!s.isEmpty()){
            res.add(s.pop());
        }
        return res;
    }
    
    public boolean isLeaf(TreeNode n){
       return n.left == null && n.right == null;
    }
    
    public void addLeaves(List<Integer> res, TreeNode root){
        if(isLeaf(root)){
            res.add(root.val);
        }
        else {
            if(root.left != null){
                addLeaves(res, root.left);
            }
            if(root.right != null){
                addLeaves(res, root.right);
            }
        }
    }
}