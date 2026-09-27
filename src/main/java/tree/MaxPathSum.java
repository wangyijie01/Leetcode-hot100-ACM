package tree;

import java.util.Scanner;

/**
 *  124. 二叉树中的最大路径和
 */
public class MaxPathSum {
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        back(root);
        return max;
    }
    public static int back(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = back(root.left);
        int r = back(root.right);
        max = Math.max(max, l + r + root.val);
        return Math.max(Math.max(l, r) + root.val, 0);
    }
    public static void main(String[] atgs){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nodes = line.split(",");
        TreeNode root = TreeNode.buildTree(nodes);
        System.out.println(maxPathSum(root));
    }
}
