package com.adenisov.sortedlist;

public class List {

	private Node head;
	private Node current;
	
	private void sort(Node node) {
		
		current = head;
		
		if (head == null) {
			
			head = node;
			node.next = head;
			
		} else if (current.value >= node.value) {

			while (current.next != head) {
				current = current.next;
			}
			
			current.next = node;
			node.next = head;
			head = node;
			
		} else {
			
			while ((current.next != head) && current.next.value < node.value) {
				current = current.next;
			}
			
			node.next = current.next;
			current.next = node;
		}
	}

	public void print() {
		
		current = head;
		
		do {
			System.out.print(current.value + " ");
			current = current.next;
			
		} while (current != head);
	}
	
	public void insert(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			Node node = new Node(elements[i]);
			sort(node);
		}
	}

}
