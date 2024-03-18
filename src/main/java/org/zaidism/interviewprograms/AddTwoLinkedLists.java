package org.zaidism.interviewprograms;

//l1 = 1 -> 2 -> 3  --- 123
//l2 = 1 ->1        ---  11
//ans = 1 -> 3 -> 4 -- 134 ---  123+11=134
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null; // Initialize next pointer
    }
}


public class AddTwoLinkedLists {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);

        AddTwoLinkedLists solution = new AddTwoLinkedLists();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
