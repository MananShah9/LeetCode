// Deepest Leaves Sum

// Given the root of a binary tree, return the sum of values of its deepest leaves.
 

// Example 1:


// Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
// Output: 15
// Example 2:

// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 19
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// 1 <= Node.val <= 100
//    Hide Hint #1  
// Traverse the tree to find the max depth.
//    Hide Hint #2  
// Traverse the tree again to compute the sum required.
// Code:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDepth;
    int sum=0;
    public void findMaxDepth(int depth, TreeNode temp){
        if(temp.left==null&& temp.right==null){
            if(depth>maxDepth){
                sum=temp.val;
                maxDepth=depth;
            }
            else if(depth==maxDepth){
                sum=sum+temp.val;
            }
            return;
        }
        else{
            if(temp.left!=null){
                findMaxDepth(depth+1,temp.left);
            }
            if(temp.right!=null){
                findMaxDepth(depth+1,temp.right);
            }
            return;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        findMaxDepth(0,root);
        return sum;
    }
}