public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode mid = midNode(head);
        ListNode newH = reverse(mid.next);
        ListNode a = head;
        ListNode b = newH;

        while (b != null) {
            if (a.val != b.val) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }

    public ListNode reverse(ListNode listNode) {
        ListNode previous = null;
        ListNode current = listNode;
        ListNode forward = null;

        if (current == null || current.next == null)
            return listNode;
        else {

            while (current != null) {
                forward = current.next;
                current.next = previous;
                previous = current;
                current = forward;
            }
        }
        return previous;
    }

    public ListNode midNode(ListNode listNode) {
        if (listNode == null || listNode.next == null)
            return listNode;
        ListNode first = listNode;
        ListNode second = listNode;
        while (second.next != null && second.next.next != null) {
            second = second.next.next;
            first = first.next;
        }
        return first;
    }
}
