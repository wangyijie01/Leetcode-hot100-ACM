package tree;
import java.util.*;
/**
 * 二叉树的公共祖先
 */
public class LowestCommonAncestor {
    public static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int v){
            val = v;
            left = null;
            right = null;
        }
        public TreeNode(int v, TreeNode l, TreeNode r){
            val = v;
            left = l;
            right = r;
        }
    }

    public static TreeNode buildTree(String[] nodes){
        if(nodes == null || nodes.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while(index < nodes.length && !queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(index < nodes.length && !nodes[index].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.left);
            }
            index++;
            if(index < nodes.length && !nodes[index].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.right);
            }
            index++;
        }

        return root;
    }

    public static TreeNode findNode(TreeNode root, int v){
        if(root == null || root.val == v){
            return root;
        }
        TreeNode l = findNode(root.left, v);
        TreeNode r = findNode(root.right, v);
        return l == null ? r : l;
    }
    public static void main(String[] atgs){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nodes = line.split(",");
        TreeNode root = buildTree(nodes);
        int pVal = sc.nextInt();
        TreeNode p = findNode(root, pVal);
        int qVal = sc.nextInt();
        TreeNode q = findNode(root, qVal);

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }




    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if(l != null && r != null){
            return root;
        }
        return l == null ? r : l;

    }

}
