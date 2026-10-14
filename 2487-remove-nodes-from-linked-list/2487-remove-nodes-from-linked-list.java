class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);

        ListNode current = head;
        int max = current.val;

        while (current.next != null) {
            if (current.next.val < max) {
                current.next = current.next.next;
            } else {
                current = current.next;
                max = current.val;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}