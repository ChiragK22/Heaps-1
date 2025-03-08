class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Iterate through the array
        for (int num : nums) {
            minHeap.offer(num); // Add the current element to the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if the size exceeds k
            }
        }

        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }
}

/*
   Time Complexity: O(n log k)
   - We traverse through the entire array, which takes O(n) time.
   - For each element, we perform a heap operation (insertion or deletion) which takes O(log k) time. 
   - Therefore, the overall time complexity is O(n log k), which is efficient for large inputs.
   
   Space Complexity: O(k)
   - The space complexity is O(k) because we are storing at most `k` elements in the heap at any time.
*/