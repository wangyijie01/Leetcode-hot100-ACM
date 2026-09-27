package tree;

import java.util.Scanner;

/**
 * 543. 二叉树的直径
 */
public class DiameterOfBinaryTree {
    static int res;
    public static int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }
    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        res = Math.max(res, l + r + 1);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] atgs){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nodes = line.split(",");
        TreeNode root = TreeNode.buildTree(nodes);
        System.out.println(diameterOfBinaryTree(root));
    }

}
