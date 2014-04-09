package javaclasses;

import java.io.*;

class LinkList {
	private Node1 first;
	private Node1 last;

	public LinkList() {
		first = null;
		last = null;
	}

	public void insertLast(int x) {
		Node1 newNode = new Node1(x);
		newNode.next = null;
		if (isEmpty())
			first = newNode;
		else
			last.next = newNode;
		last = newNode;
	}

	public int deleteFirst() {
		int t = first.data;
		if (first.next == null)
			last = null;
		first = first.next;
		return t;
	}

	public int peekFirst() {
		return (first.data);
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void displayList() {
		Node1 current = first;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
	}
}

class Queue {
	private LinkList l;

	public Queue() {
		l = new LinkList();
	}

	public void insert(int x) {
		l.insertLast(x);
		System.out.print("Inserted");
	}

	public int delete() {
		return l.deleteFirst();
	}

	public boolean isQueueEmpty() {
		return l.isEmpty();
	}

	public void display() {
		l.displayList();
	}

	public int peek() {
		return l.peekFirst();
	}
}

class Node1 {
	public int data;
	public Node1 next;

	public Node1(int x) {
		data = x;
	}

	public void displayNode() {
		System.out.print(data + "  ");
	}
}

class QueueLinkedList {
	public static void main(String args[]) throws IOException {
		String ch = "y";
		DataInputStream inp = new DataInputStream(System.in);
		int n, d;
		Queue q = new Queue();
		while (ch.equals("y")) {
			System.out.println("MENU");
			System.out.println("--------");
			System.out.println("1.Insert");
			System.out.println("2.Delete");
			System.out.println("3.Peek");
			System.out.println("4.Display");
			System.out.println("Enter your choice ");
			n = Integer.parseInt(inp.readLine());
			switch (n) {
			case 1:
				System.out.println("Enter the data ");
				d = Integer.parseInt(inp.readLine());
				q.insert(d);
				break;
			case 2:
				if (q.isQueueEmpty())
					System.out.print("Queue is Empty ");
				else {
					d = q.delete();
					System.out.print("Deleted data:-  " + d);
				}
				break;
			case 3:
				if (q.isQueueEmpty())
					System.out.print("Queue is Empty ");
				else {
					d = q.peek();
					System.out.print("Deleted data:-  " + d);
				}
				break;
			case 4:
				if (q.isQueueEmpty())
					System.out.print("Queue is Empty ");
				else {
					System.out.print("Datas in Queue ");
					q.display();
				}
				break;
			default:
				System.out.print("Invalid choice ");
			}
			System.out.println("");
			System.out.print("Enter y to continue ");
			ch = inp.readLine();
		}
	}
}