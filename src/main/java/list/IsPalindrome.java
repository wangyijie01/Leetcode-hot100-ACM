package list;

import java.util.Scanner;

/**
 * 234. 回文链表
 */
public class IsPalindrome {

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


    public static boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode head2 = reverse(mid);
        while(head2 != null){
            if(head.val != head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head){
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nodes = line.split(",");
        ListNode head = buildList(nodes);
        System.out.println(isPalindrome(head));
    }
}
