package list;

import java.util.Scanner;

/**
 * k个一组的翻转链表
 */
public class ReverseKGroup {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int v){
            val = v;
            next = null;
        }

    }
    public static ListNode buildList(String[] nodes){
        if(nodes == null || nodes.length == 0){
            return null;
        }
        ListNode head = new ListNode(Integer.parseInt(nodes[0]));
        int index = 1;
        ListNode cur = head;
        while(index < nodes.length){
            cur.next = new ListNode(Integer.parseInt(nodes[index++]));
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int k = sc.nextInt();
        String[] nodes = line.split(",");
        ListNode head = buildList(nodes);
        ListNode newHead = reverseKGroup(head, k);
        for(ListNode cur = newHead; cur != null; cur = cur.next){
            System.out.print(cur.val + ", ");
        }
        System.out.println();
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        int len = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            len++;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode cur = head;
        ListNode pre = null;

        for(; len >= k ; len -= k){
            for(int i = 0; i < k; i++){
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            ListNode tmp = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = tmp;
        }

        return dummy.next;
    }
}
