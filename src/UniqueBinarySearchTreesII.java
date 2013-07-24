public class UniqueBinarySearchTreesII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return gt(0, n);
    }
    
    ArrayList<TreeNode> gt(int start, int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start >= end){
            TreeNode root = null;
            result.add(root);
            return result;      
        }
        ArrayList<TreeNode> childrenL, childrenR;
        for (int i = start; i < end; i++){
            childrenL = gt(start, i);
            childrenR = gt(i + 1, end);
            for (int j = 0; j < childrenL.size(); j++){
                for (int k = 0; k < childrenR.size(); k++){
                    TreeNode root = new TreeNode(i + 1);
                    root.left = childrenL.get(j);
                    root.right = childrenR.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
