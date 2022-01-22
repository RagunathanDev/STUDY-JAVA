package com.dsa.linkedlist;

public class LinkedList {

	Node head;

	static class Node {

		int value;
		Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	// InsertBegin
	void insertAtBeginning(int value) {
		Node new_Node = new Node(value);
		new_Node.next = head;
		head = new_Node;
	}

	// InsertBetweenTwoNode
	void insertAfter(Node prev_Node, int value) {

		if (prev_Node.next != null) {
			System.out.print("Previous node next not be a null");
		}

		Node new_Node = new Node(value);
		new_Node.next = prev_Node.next;
		prev_Node.next = new_Node;

	}

	// Insertion at end
	void insertAtEnd(int value) {

		Node new_Node = new Node(value);

		if (head == null) {
			head = new_Node;
			return;
		}

		Node last = head;

		// looping through last before node (i.e : last = last before node)
		while (last.next != null) {
			last = last.next;
		}

		last.next = new_Node;
		return;
	}

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();

		linkedList.head = new Node(11);

		Node second = new Node(12);

		Node third = new Node(13);

		linkedList.head.next = second;
		second.next = third;

//		while (linkedList.head.next != null) {
//			System.out.print(linkedList.head.value + " ");
//			linkedList.head = linkedList.head.next;
//		}

		/* LinkedList Operations */
//		Traversal - access each element of the linked list
//		Insertion - adds a new element to the linked list
//		Deletion - removes the existing elements
//		Search - find a node in the linked list
//		Sort - sort the nodes of the linked list
		LinkedList linkedList1 = new LinkedList();

		linkedList1.insertAtEnd(1);
		linkedList1.insertAtBeginning(2);
		linkedList1.insertAtBeginning(3);
		linkedList1.insertAtEnd(4);
		// linkedList1.insertAfter(linkedList1.head.next, 5);

		System.out.println();
		while (linkedList1.head.next != null) {
			System.out.print(linkedList1.head.value + " ");
			linkedList1.head = linkedList1.head.next;
		}
		System.out.print(linkedList1.head.value + " ");
	}
}
