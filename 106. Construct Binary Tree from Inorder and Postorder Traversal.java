class Solution {
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        postIndex = postorder.length-1;
        return helper(0, inorder.length-1);
    }
    
    private TreeNode helper(int start, int end){
        if(start > end){
            return null;
        }
        int rootVal = this.postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = map.get(rootVal);
        this.postIndex--;
        root.right = helper(rootIndex+1, end);
        root.left = helper(start, rootIndex-1);
        return root;
    }
}


//Question leet code 105, 106 why the boundry of left and right tree is different?