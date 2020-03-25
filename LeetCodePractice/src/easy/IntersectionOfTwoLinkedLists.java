package easy;

/**
 * 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * 160. Intersection of Two Linked Lists
 * 
 * @author srimeda
 *
 */
public class IntersectionOfTwoLinkedLists {

	/**
	 * Approach 1: Brute Force For each node ai in list A, traverse the entire list
	 * B and check if any node in list B coincides with ai.
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity : O(mn)O(mn).
	 * 
	 * Space complexity : O(1)O(1).
	 */
	public static ListNode getIntersectionNode_BF(ListNode headA, ListNode headB) {
        ListNode refA = headA;
        ListNode refB = headB;
        
        while(refA != null) {
        	int value = refA.val;
        	refB = headB;
        	while(refB != null) {
        		if(value == refB.val) {
        			return refB;
        		} else {
        			refB = refB.next;
        		}
        	}
        	refA = refA.next;
        }
        
        
        return refA;
    }
	
	/**
	 * Approach 2: Hash Table Traverse list A and store the address / reference to
	 * each node in a hash set. Then check every node bi in list B: if bi appears in
	 * the hash set, then bi is the intersection node.
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity : O(m+n)O(m+n).
	 * 
	 * Space complexity : O(m)O(m) or O(n)O(n).
	 */

	/**
	 * Approach 3: Two Pointers
	 * 
	 * Maintain two pointers pApA and pBpB initialized at the head of A and B,
	 * respectively. Then let them both traverse through the lists, one node at a
	 * time.
	 * 
	 * When pApA reaches the end of a list, then redirect it to the head of B (yes,
	 * B, that's right.); similarly when pBpB reaches the end of a list, redirect it
	 * the head of A.
	 * 
	 * If at any point pApA meets pBpB, then pApA/pBpB is the intersection node.
	 * 
	 * To see why the above trick would work, consider the following two lists: A =
	 * {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since
	 * B.length (=4) < A.length (=6), pBpB would reach the end of the merged list
	 * first, because pBpB traverses exactly 2 nodes less than pApA does. By
	 * redirecting pBpB to head A, and pApA to head B, we now ask pBpB to travel
	 * exactly 2 more nodes than pApA would. So in the second iteration, they are
	 * guaranteed to reach the intersection node at the same time.
	 * 
	 * If two lists have intersection, then their last nodes must be the same one.
	 * So when pApA/pBpB reaches the end of a list, record the last element of A/B
	 * respectively. If the two last elements are not the same one, then the two
	 * lists have no intersections.
	 * 
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode refA = headA;
		ListNode refB = headB;

		while (refA != refB) {
			refA = refA != null ? refA.next : headB;
			refB = refB != null ? refB.next : headA;
		}

		return refA;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(7);
		l1.next.next.next.next = new ListNode(6);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(7);
		l2.next.next.next = new ListNode(6);
		
		ListNode result = getIntersectionNode(l1, l2);
//		ListNode result = getIntersectionNode_BF(l1, l2);
		System.out.println(result != null ? result.val : "null");
	}
}
