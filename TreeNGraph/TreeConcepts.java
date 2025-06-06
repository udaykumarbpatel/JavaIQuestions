package javaclasses;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node2 {
	public int item;
	public Node2 leftChild;
	public Node2 rightChild;
	public Node2 parent;

	public void displayNode() {
		System.out.print("[");
		System.out.print(item);
		System.out.print("]");
	}
}

class StackNode2 {
	public Node2 item;
	public StackNode2 next;

	public StackNode2(Node2 val) {
		item = val;
	}

}

class LinkedListStack2 {
	private StackNode2 first;

	public LinkedListStack2() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insert(Node2 key)// inserts at beginning of list
	{
		StackNode2 newLLNode = new StackNode2(key);
		newLLNode.next = first;
		first = newLLNode;
	}

	public Node2 delete()// deletes at beginning of list
	{
		StackNode2 temp = first;
		first = first.next;
		return temp.item;
	}
}

class Stack2 {
	private LinkedListStack2 listObj;

	public Stack2() {
		listObj = new LinkedListStack2();
	}

	public void push(Node2 num) {
		listObj.insert(num);
	}

	public Node2 pop() {
		return listObj.delete();
	}

	public boolean isEmpty() {
		return listObj.isEmpty();
	}
}

class TreeConcepts {
	public Node2 root;
	public int max = 0;

	public TreeConcepts() {
		root = null;
	}

	public Node2 returnRoot() {
		return root;
	}

	public void insert(int id) {
		Node2 newNode = new Node2();
		newNode.item = id;
		newNode.parent = null;
		if (root == null)
			root = newNode;
		else {
			Node2 current = root;
			Node2 parent;
			while (true) {
				parent = current;
				if (id < current.item) {
					current = current.leftChild;
					if (current == null) {
                                                parent.leftChild = newNode;
                                                newNode.parent = parent;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
                                                parent.rightChild = newNode;
                                                newNode.parent = parent;
						return;
					}
				}
			}
		}
	}

	public void preOrder(Node2 Root) {
		if (Root != null) {
			System.out.print(Root.item + " ");
			preOrder(Root.leftChild);
			preOrder(Root.rightChild);
		}
	}

	public void inOrder(Node2 Root) {
		if (Root != null) {
			inOrder(Root.leftChild);
			System.out.print(Root.item + " ");
			inOrder(Root.rightChild);
		}
	}

	public void postOrder(Node2 Root) {
		if (Root != null) {
			postOrder(Root.leftChild);
			postOrder(Root.rightChild);
			System.out.print(Root.item + " ");
		}
	}

	public void byLevel(Node2 root) {
		Queue<Node2> level = new LinkedList<>();
		level.add(root);

		while (!level.isEmpty()) {
			Node2 node = level.poll();
			System.out.print(node.item + " ");
			if (node.leftChild != null)
				level.add(node.leftChild);
			if (node.rightChild != null)
				level.add(node.rightChild);
		}
	}

	public void displayTree() {
		Stack2 globalStack = new Stack2();
		globalStack.push(root);
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out
				.println("****......................................................****");
		while (isRowEmpty == false) {

			Stack2 localStack = new Stack2();
			isRowEmpty = true;
			for (int j = 0; j < emptyLeaf; j++)
				System.out.print(' ');
			while (globalStack.isEmpty() == false) {
				Node2 temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.item);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < emptyLeaf * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out
				.println("****......................................................****");
	}

	public int successor(int i) {
		Node2 x = new Node2();

		if (root == null)
			x = null;
		else {
			Node2 current = root;
			boolean flag = true;
			while (flag) {
				if (i < current.item) {
					current = current.leftChild;
				} else if (i > current.item) {
					current = current.rightChild;
				} else if (i == current.item) {
					x = current;
					flag = false;
				}
			}
		}

		if (x.rightChild != null) {
			return minimum(x.rightChild).item;
		}
		Node2 y = x.parent;
		while (y != null && x == y.rightChild) {
			x = y;
			y = y.parent;
		}
		return y.item;
	}

	public int predecessor(int i) {
		Node2 x = new Node2();

		if (root == null)
			x = null;
		else {
			Node2 current = root;
			boolean flag = true;
			while (flag) {
				if (i < current.item) {
					current = current.leftChild;
				} else if (i > current.item) {
					current = current.rightChild;
				} else if (i == current.item) {
					x = current;
					flag = false;
				}
			}
		}

		if (x.leftChild != null) {
			return maximum(x.leftChild).item;
		}
		Node2 y = x.parent;
		while (y != null && x == y.leftChild) {
			x = y;
			y = y.parent;
		}
		return y.item;
	}

	private Node2 maximum(Node2 leftChild) {
		while (leftChild.rightChild != null)
			leftChild = leftChild.rightChild;
		return leftChild;
	}

	private Node2 minimum(Node2 rightChild) {
		while (rightChild.leftChild != null)
			rightChild = rightChild.leftChild;
		return rightChild;
	}

	public void printLeftNRightViewOfBT(Node2 node) {
		Queue<Node2> queue = new LinkedList<Node2>();
		Node2 LS = new Node2();
		queue.add(node);
		queue.add(LS);

		// left view and right view arrays
		ArrayList<Node2> leftView = new ArrayList<Node2>();
		ArrayList<Node2> rightView = new ArrayList<Node2>();
		leftView.add(node);

		while (!queue.isEmpty()) {
			Node2 currentNode = queue.remove();
			// Left View
			if (currentNode.equals(LS)) {
				if (!queue.isEmpty()) {
					leftView.add(queue.peek());
					queue.add(LS);
				}
			}
			// Right View
			 if (!queue.isEmpty() && queue.peek().equals(LS)) {
			 rightView.add(currentNode);
			 }
			// Left View
			if (currentNode.leftChild != null) {
				queue.add(currentNode.leftChild);
			}
			// Right View
			if (currentNode.rightChild != null) {
				queue.add(currentNode.rightChild);
 }
		}

		System.out.println("Left View   : ");
		for (Node2 n : leftView)
			System.out.print(n.item + " ");

		System.out.println("\nRight View   : ");
		for (Node2 n : rightView)
			System.out.print(n.item + " ");

	}

	public static void main(String[] args) throws IOException {
		// int value;
		TreeConcepts theTree = new TreeConcepts();
		theTree.insert(42);
		theTree.displayTree();
		theTree.insert(25);
		theTree.displayTree();
		theTree.insert(65);
		theTree.displayTree();
		theTree.insert(12);
		theTree.displayTree();
		theTree.insert(37);
		theTree.displayTree();
		theTree.insert(13);
		theTree.displayTree();
		theTree.insert(30);
		theTree.displayTree();
		theTree.insert(43);
		theTree.displayTree();
		theTree.insert(87);
		theTree.displayTree();
		theTree.insert(99);
		theTree.displayTree();
		theTree.insert(9);
		theTree.displayTree();
		// theTree.successor(87);

		System.out.println("Displaying the tree");
		theTree.displayTree();

		System.out.println("Inorder traversal");
		theTree.inOrder(theTree.returnRoot());
		System.out.println(" ");

		System.out.println("Preorder traversal");
		theTree.preOrder(theTree.returnRoot());
		System.out.println(" ");

		System.out.println("Postorder traversal");
		theTree.postOrder(theTree.returnRoot());
		System.out.println(" ");

		System.out.println("By Level");
		theTree.byLevel(theTree.returnRoot());
		System.out.println(" ");

		System.out.println("\n");
		System.out.println("By Successor   :  " + theTree.successor(87));
		System.out.println("\n");
		System.out.println("By predecessor   :  " + theTree.predecessor(25));

		System.out.println("\n");
		theTree.printLeftNRightViewOfBT(theTree.returnRoot());

	}
}
