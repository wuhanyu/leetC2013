/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode *root) {
        if (!root) return 0;
        int count = 1;
        vector<TreeNode> list;
        list.push_back(*root);
        while (!list.empty()){
            vector<TreeNode> nextlist;
            for (int i = 0; i < list.size(); i++){
                if (!list[i].left && !list[i].right) return count;
                if (list[i].left) nextlist.push_back(*list[i].left);
                if (list[i].right) nextlist.push_back(*list[i].right);
            }
            list = nextlist;
            count++;
        }
        return count;
    }
};
