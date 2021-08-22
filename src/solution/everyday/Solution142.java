package solution.everyday;
/*
* 快慢指针做法 但是快慢指针只能寻找有没有环
* 所以还得引入第三个指针在找到环时（快指针指向头节点也行） 从头开始来和low一起一步一步移动，相遇的时候就是入环节点（数学验证见力扣）
* */
public class Solution142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode low = head;
        ListNode high = head;
        while (low != null && high != null) {
            low = low.next;
            if(high.next!= null)
                high = high.next.next;
            else
                return null;
            if (low == high) {
                ListNode p = head;
//               high = head;
                while(p != low)
                {
                    p = p.next;
                    low = low.next;
                }
                return p;
            }
        }
        return null;
    }
}
