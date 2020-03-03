package LeetCode;

public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l1 == null)
                return l2;
            else
                return l1;
        }
        ListNode preNode = new ListNode(-1);
        ListNode prevNode = preNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prevNode.next = l1;
                l1 = l1.next;
            } else {
                prevNode.next = l2;
                l2 = l2.next;
            }
            prevNode = prevNode.next;
        }
        prevNode.next = l1 == null ? l2 : l1;
        return preNode.next;
    }
}
