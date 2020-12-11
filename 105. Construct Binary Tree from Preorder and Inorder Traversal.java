class Solution {
    int[] preorder;
    int[] inorder;
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper(0, inorder.length);
    }
    
    private TreeNode helper(int start, int end){
        if(start == end){
            return null;
        }
        int rootVal = this.preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        
        int root_index = map.get(rootVal);
        preIndex++;
        
        root.left = helper(start, root_index);
        root.right = helper(root_index+1, end);
        return root;
    }
}