package list;

import java.util.Scanner;

public class ReverseKGroup {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode build(String[] nodes){
        if(nodes == null || nodes.length == 0){
            return null;
        }
        ListNode head = new ListNode(Integer.parseInt(nodes[0]));
        ListNode cur = head;
        for(int i = 1; i < nodes.length; i++){
            cur.next = new ListNode(Integer.parseInt(nodes[i]));
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nodes = line.split(",");
        ListNode head = build(nodes);
        int k = sc.nextInt();
        ListNode newHead = reverseKGroup(head, k);
        for(ListNode node = newHead; node != null; node = node.next){
            System.out.print(node.val + ",");
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null){
            return head;
        }
        int length = 0;
        for(ListNode node = head; node != null; node = node.next){
            length++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode cur = head;
        ListNode pre = null;

        for(; length >= k; length -= k){
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
