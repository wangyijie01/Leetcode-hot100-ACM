package other;

/*

 */
public class Test {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int v){
            val = v;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            n++;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode p1 = dummy;

        for(; n >= k; n -= k){
            for(int i = 0; i < k; i++){
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }

            ListNode tmp = p1.next;
            p1.next.next = cur;
            p1.next = pre;
            p1 = tmp;
        }
        return dummy.next;


    }

}
