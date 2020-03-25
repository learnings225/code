package easy;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * 21. Merge Two Sorted Lists
 * 
 * @author srimeda
 *
 */
public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode temp = new ListNode(-1);
        ListNode result = new ListNode(-1);
        result = temp;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                temp = temp.next;
                l2 = l2.next;
            }
        }
        
        while(l1 != null) {
            temp.next = new ListNode(l1.val);
            temp = temp.next;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            temp.next = new ListNode(l2.val);
            temp = temp.next;
            l2 = l2.next;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode result = mergeTwoLists(l1, l2);
		System.out.println(result.val);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
