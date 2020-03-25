package easy;

public class RemoveDuplicatesSortedList2 {
//	public static ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null) {
//            return head;
//        }
//        
//        ListNode current = head;
//        
//        while(current.next != null) {
//            if(current.val == current.next.val) {
//            	int value = current.val;
//                while(current.val == value) {
//                    current.val = current.next.val;
//                    current.next = current.next.next;
//                }
//            } else {
//            	current = current.next;
//            }
//        }
//        
//        return head;
//    }
	
	public static ListNode deleteDuplicates(ListNode head) {
		
		ListNode temp = head;
		ListNode prev = null;

		while (temp != null) {
			ListNode curr = temp;
			
			while (temp != null && temp.next != null && temp.val == temp.next.val) {
				temp = temp.next;
			}
			
			if (curr != temp) {
				if (prev == null) {
					head = temp.next;
				} else {
					prev.next = temp.next;
				}
			} else {
				prev = temp;
			}
			
			temp = temp.next;
		}
		
		return head;
//        
//        if(head == null || head.next == null) {
//            return head;
//        }
//        
//        ListNode current = head;
//        
//        while(current != null && current.next != null) {
//            if(current.val == current.next.val) {
//                int value = current.val;
//                while(current != null && current.val == value) {
//                    if(current.next == null) {
//                        current.val = 0;
//                        current.next = null;
//                    } else {
//                        current.val = current.next.val;
//                        current.next = current.next.next;
//                    }
//                }
//            } else {
//                current = current.next;
//            }
//        }
//        
//        return head;
    }
	
	public static void main(String[] args) {
//		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(3);
//		l1.next.next.next = new ListNode(3);
//		l1.next.next.next.next = new ListNode(4);
//		l1.next.next.next.next.next = new ListNode(4);
//		l1.next.next.next.next.next.next = new ListNode(5);
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(1);
		
		ListNode result = deleteDuplicates(l1);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}