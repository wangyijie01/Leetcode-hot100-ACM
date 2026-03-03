package list;
import java.util.Scanner;

/**
 * 相交链表
 */
public class GetIntersectionNode {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int v){
            val = v;
            next = null;
        }
    }

    // 构建单个链表
    public static ListNode buildList(String[] str){
        if(str == null || str.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1); //虚拟头节点
        ListNode cur = dummy;
        for(String s : str){
            cur.next = new ListNode(Integer.parseInt(s));
            cur = cur.next;
        }
        return dummy.next;
    }

    // 构建相交链表：根据 skipA 和 skipB 将 B 的尾部接到 A 的指定节点
    public static ListNode[] buildIntersectionLists(String[] arrA, String[] arrB, int skipA, int skipB) {
        // 先构建 A 完整链表
        ListNode headA = buildList(arrA);
        // 构建 B 的前 skipB 个节点，然后连接到 A 的第 skipA 个节点
        ListNode dummyB = new ListNode(-1);
        ListNode curB = dummyB;
        for (int i = 0; i < skipB; i++) {
            curB.next = new ListNode(Integer.parseInt(arrB[i]));
            curB = curB.next;
        }
        // 找到 A 中第 skipA 个节点（相交节点）
        ListNode intersectNode = headA;
        for (int i = 0; i < skipA; i++) {
            intersectNode = intersectNode.next;
        }
        // 将 B 的剩余部分连接到相交节点（实际上相交节点之后的节点是共享的）
        curB.next = intersectNode; // B 的尾部指向相交节点，之后的节点共享 A 的部分

        // B 的头节点
        ListNode headB = dummyB.next;
        return new ListNode[]{headA, headB};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] arrA = str1.split(",");
        String[] arrB = str2.split(",");
        int skipA = sc.nextInt();
        int skipB = sc.nextInt();
        // 构建相交链表
        ListNode[] heads = buildIntersectionLists(arrA, arrB, skipA, skipB);
        ListNode headA = heads[0];
        ListNode headB = heads[1];

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        // 安全输出：如果相交打印节点值，否则打印 null
        if (intersectionNode != null) {
            System.out.println(intersectionNode.val);
        } else {
            System.out.println("null");
        }
        sc.close();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != node2){
            node1 = (node1 != null ? node1.next : headB);
            node2 = (node2 != null ? node2.next : headA);
        }
        return node1;
    }
}
