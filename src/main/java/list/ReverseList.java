package list;

import java.util.Scanner;

public class ReverseList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
    private static ListNode buildListNode(String[] nodes) {
        if(nodes == null || nodes.length == 0){
            return null;
        }
        ListNode head = new ListNode(Integer.valueOf(nodes[0]));
        ListNode cur = head;
        for(int i = 1; i < nodes.length; i++){
            cur.next = new ListNode(Integer.valueOf(nodes[i]));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nodes = line.split(",");
        ListNode head = buildListNode(nodes);

        ListNode reverseHead = reverseList(head);
        while(reverseHead != null){
            System.out.print(reverseHead.val + " ");
            reverseHead = reverseHead.next;
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
