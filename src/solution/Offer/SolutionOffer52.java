package solution.Offer;

//剑指 Offer 52. 两个链表的第一个公共节点
public class SolutionOffer52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
//            如果a遍历完了 就指向b 否则下一个
            a = a == null ? headB: a.next;
            b = b == null ? headA: b.next;
        }
        return a;
    }
}
