package com.practice.codesignal;

import com.practice.codesignal.FindShapeArea.ListNode;

public class MergeTwoLinkedLists {
	//
	ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		ListNode<Integer> resultList = new ListNode<Integer>(null);

		while (l1 != null && l2 != null) {
			if (l1.value < l2.value) {
				ListNode<Integer> temp = l1;
				resultList.next = temp;
				resultList = resultList.next;
				l1 = l1.next;
			} else {
				resultList.next = l2;
				l2 = l2.next;
			}
		}

		while (l1 != null) {
			resultList.next = l1;
			l1 = l1.next;
		}

		while (l2 != null) {
			resultList.next = l2;
			l2 = l2.next;
		}

		return resultList.next;
	}

	public static void main(String[] args) {
		MergeTwoLinkedLists ml = new MergeTwoLinkedLists();
		ListNode<Integer> l1 = new ListNode<Integer>(1);
		l1.next = new ListNode<Integer>(2);
		l1.next.next = new ListNode<Integer>(3);

		ListNode<Integer> l2 = new ListNode<Integer>(4);
		l2.next = new ListNode<Integer>(5);
		l2.next.next = new ListNode<Integer>(6);
		System.out.println(ml.mergeTwoLinkedLists(l1, l2));
	}
}
