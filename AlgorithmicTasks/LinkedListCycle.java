/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head != null) {
            ListNode fastPointer = head.next;
            while (fastPointer != null) {
                if(head == fastPointer) {
                    return true;
                }
                head = head.next;
                fastPointer = (fastPointer.next != null) ? fastPointer.next.next : null;
            }
        }
        return false;
    }
}
