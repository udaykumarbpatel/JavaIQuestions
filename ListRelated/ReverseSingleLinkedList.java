package javaclasses;

public class ReverseSingleLinkedList {
	private int data;
	private ReverseSingleLinkedList next;

	public ReverseSingleLinkedList() {
		data = 0;
		next = null;
	}

	public ReverseSingleLinkedList(int value) {
		data = value;
		next = null;
	}

	public ReverseSingleLinkedList InsertNext(int value) {
		ReverseSingleLinkedList node = new ReverseSingleLinkedList(value);
		if (this.next == null) {
			// Easy to handle
			node.next = null; // already set in constructor
			this.next = node;
		} else {
			// Insert in the middle
			ReverseSingleLinkedList temp = this.next;
			node.next = temp;
			this.next = node;
		}
		return node;
	}

	public int DeleteNext() {
		if (next == null)
			return 0;

		ReverseSingleLinkedList node = this.next;
		this.next = this.next.next; // can be NULL here
		node = null;
		return 1;
	}

	public void Traverse(ReverseSingleLinkedList node) {
		if (node == null)
			node = this;
		System.out.println("\n\nTraversing in Forward Direction\n\n");

		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public ReverseSingleLinkedList Reverse_With_Bubble(ReverseSingleLinkedList head) {
		ReverseSingleLinkedList testnode = null;
		if (head == null)
			return head;

		while (true) {
			ReverseSingleLinkedList p = head;
			if (p.next == testnode)
				break;
			while (true) {
				int temp = p.data;
				p.data = p.next.data;
				p.next.data = temp;
				p = p.next;
				if (p.next == testnode) {
					testnode = p;
					break;
				}
			}
		}
		return head;
	}

	public ReverseSingleLinkedList Reverse(ReverseSingleLinkedList head) {
		if (head == null)
			return head;

		ReverseSingleLinkedList cp = head;
		ReverseSingleLinkedList prev = null;

		while (cp != null) {
			ReverseSingleLinkedList next = cp.next;
			cp.next = prev;
			prev = cp;
			cp = next;
		}
		head = prev;
		return head;
	}

	public ReverseSingleLinkedList Reverse_with_copy(ReverseSingleLinkedList head) {
		ReverseSingleLinkedList p = head;
		ReverseSingleLinkedList newhead = null;
		while (true) {
			if (p == null)
				return newhead;
			ReverseSingleLinkedList newnode = new ReverseSingleLinkedList(p.data);
			newnode.next = newhead;
			newhead = newnode;
			p = p.next;
		}
	}

	public static void main(String[] args) {
		ReverseSingleLinkedList head = new ReverseSingleLinkedList(1);
		ReverseSingleLinkedList p = head.InsertNext(2);
		p = p.InsertNext(3);
		p = p.InsertNext(4);
		p = p.InsertNext(5);
		p = p.InsertNext(6);
		p = p.InsertNext(7);
		p = p.InsertNext(8);

		head.Traverse(null);

		ReverseSingleLinkedList newhead = head.Reverse(head);
		newhead.Traverse(null);

	}
}