package tree;
import java.util.*;

/**
 * @Author: wangyijie
 * @Description: 层序遍历
 */
public class LevelOrder {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v){
            this.val = v;
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
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nodes = line.split(",");
        TreeNode root = buildTree(nodes);
        System.out.println(levelOrder(root));
        sc.close();
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> l = new LinkedList<>();
            while(size > 0){
                TreeNode cur = queue.poll();
                l.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                size--;
            }
            res.add(l);
        }
        return res;
    }
}
