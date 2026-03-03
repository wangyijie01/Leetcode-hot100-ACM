package Hash;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @Author: wangyijie
 * @Description: 路径总合
 * 10 5 -3 3 2 null 11 3 -2 null 1
 * 8
 * 3
 *
 * 5 4 8 11 null 13 4 7 2 null null 5 1
 * 22
 * 3
 */
public class PathSum {
    //二叉树结构
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    //根据层序遍历的字符串数组构建二叉树
    public static TreeNode buildTree(String[] nodes){
        // 边界条件检查
        if(nodes == null || nodes.length == 0){
            return null;
        }
        // 创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        // 使用队列存储待处理的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 数组索引，从1开始因为0已经被根节点使用
        int index = 1;
        // 层序遍历构建二叉树
        while(!queue.isEmpty() && index < nodes.length) {
            // 取出当前要处理的节点
            TreeNode cur = queue.poll();
            // 处理左子节点
            if(index < nodes.length && !nodes[index].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.left);
            }
            index++;
            // 处理右子节点
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
        int targetSum = sc.nextInt();
        String[] lines = line.split(" ");
        TreeNode root = buildTree(lines);
        System.out.println(pathSum(root, targetSum));
        sc.close();
    }


    //核心代码
    static int res = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        // key：从根到 node 的节点值之和
        // value：节点值之和的出现次数
        // 注意在递归过程中，哈希表只保存根到 node 的路径的前缀的节点值之和
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        tracking(root, targetSum, 0L, map);
        return res;
    }

    private static void tracking(TreeNode root, int targetSum, Long s, Map<Long, Integer> map){
        if(root == null){
            return;
        }
        Long sum = s + root.val;
        res += map.getOrDefault(sum - targetSum, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        tracking(root.left, targetSum, sum, map);
        tracking(root.right, targetSum, sum, map);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }
}
