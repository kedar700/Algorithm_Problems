package LeetCode;


import java.util.Stack;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l1 == null)
                return l2;
            else
                return l1;
        }
        ListNode newList = new ListNode(-1);
        ListNode tempL1 = l1, tempL2 = l2, current = newList;
        int carry = 0;
        while (tempL1 != null || tempL2 != null || carry != 0) {
            if (tempL1 != null) {
                carry += tempL1.val;
                tempL1 = tempL1.next;
            }
            if (tempL2 != null) {
                carry += tempL2.val;
                tempL2 = tempL2.next;
            }
            current.next = new ListNode(carry % 10);
            carry = carry / 10;
            current = current.next;
        }
        return newList.next;
    }

    /**
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l1 == null)
                return l2;
            else
                return l1;
        }
        Stack<Integer> stackL1 = new Stack<>();
        Stack<Integer> stackL2 = new Stack<>();

        while (l1 != null) {
            stackL1.push(l1.val);
            l1= l1.next;
        }

        while (l2 != null) {
            stackL2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode finalList = null;
        while (!stackL1.empty() || !stackL2.empty() || sum != 0) {
            if (!stackL1.empty())
                sum += stackL1.pop();

            if (!stackL2.empty())
                sum += stackL2.pop();

            ListNode node = new ListNode(sum % 10);
            node.next = finalList;
            finalList = node;
            sum /= 10;

        }
        return finalList;
    }
}
