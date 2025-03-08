/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         // Edge case: if the input array is empty, return null
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap to maintain the order of nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each linked list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Dummy head for the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Build the merged list using the min-heap
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            // Add the next node of the extracted node to the heap if it exists
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        // Return the merged list starting from the next of the dummy node
        return dummy.next;
    }
}