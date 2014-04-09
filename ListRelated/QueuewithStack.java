package javaclasses;

import java.util.Stack;

public class QueuewithStack {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	int pop;

	private boolean remove() {
		if (s1.empty()) {
			System.out.println("The stack is empty, nothing to return");
			return false;
		} else {
			pop = s1.pop();
			return true;
		}

	}

	private void add(int data) {
		for (int i = s1.size(); i > 0; i--) {
			s2.add(s1.pop());
		}
		s1.add(data);
		for (int j = s2.size(); j > 0; j--) {
			s1.add(s2.pop());
		}

	}

	public static void main(String[] args) {
		QueuewithStack q = new QueuewithStack();

		if (q.remove())
			System.out.println(q.pop);

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
		if (q.remove())
			System.out.println(q.pop);
	}

}
