package tree;
import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class LevelOrder {
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nodes = line.split(",");
        TreeNode root = buildTree(nodes);
        System.out.println(levelOrder(root));


    }

    private static TreeNode buildTree(String[] nodes) {
        if(nodes == null || nodes.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int index = 1;
        while(index < nodes.length){
            TreeNode cur = q.remove();
            if(index < nodes.length && !nodes[index].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(cur.left);
            }
            index++;
            if(index < nodes.length && !nodes[index].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(cur.right);
            }
            index++;
        }
        return root;
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            while(size-- > 0){
                TreeNode cur = q.remove();
                l.add(cur.val);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            res.add(l);
        }
        return res;
    }

}
