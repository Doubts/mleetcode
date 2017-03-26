package Algorithm.OneToFifty;

import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public String toString() {
        return val + " ";
    }
}

public class A2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // beats 47%
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode res = result;
        boolean carray = false;
        do {
            int val;
            if (carray) {
                val = l1.val + l2.val + 1;
            } else {
                val = l1.val + l2.val;
            }
            result.next = new ListNode(val % 10);

            if (val >= 10) {
                carray = true;
            } else {
                carray = false;
            }
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        } while (l1 != null && l2 != null);

        ListNode mNode = null;
        if (l1 != null) {
            mNode = l1;
        } else if (l2 != null){
            mNode = l2;
        }

        while (mNode != null) {
            int val;
            if (carray) {
                val = mNode.val + 1;
            } else {
                val = mNode.val;
            }
            result.next = new ListNode(val % 10);

            if (val >= 10) {
                carray = true;
            } else {
                carray = false;
            }
            mNode = mNode.next;
            result = result.next;
        }

        if (carray) {
            result.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
    }

}
