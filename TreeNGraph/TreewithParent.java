package javaclasses;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TreewithParent {

	private class node {
		int data;
		node left;
		node right;
		node parent;
	}

	static node root;

	public void insertNode(int data) {
		if (root == null) {
			root = new node();
			root.data = data;
			root.left = null;
			root.right = null;
			root.parent = null;
			return;
		}
		node cur = root;
		if (cur.left != null) {
			while (cur.left != null && cur.data > data) {
				cur = cur.left;
			}
		}

		if (cur.right != null) {
			while (cur.right != null && cur.data < data) {
				cur = cur.left;
			}
		}
		node temp = new node();
		temp.data = data;
		temp.left = null;
		temp.right = null;

		if (data > cur.data) {
			cur.right = temp;
		} else {
			cur.left = temp;
		}
		temp.parent = cur;
	}

	private void bfs() {
		Queue<node> q = new ArrayBlockingQueue<node>(20);
		node cur = root;
		if (root == null) {
			System.out.println("Empty Graph!");
			return;
		}
		q.add(cur);
		while (q.isEmpty() == false) {
			node top = q.remove();
			if (top != null) {
				System.out.print(" Q : " + top.data);
				if (top.parent != null)
					System.out.print(" and its parent is " + top.parent.data);
				System.out.println("");
				if (top.left != null) {
					q.add(top.left);
				}
				if (top.right != null) {
					q.add(top.right);
				}
			}
		}
	}

	public void printAllPaths(node cur, int curSum, int totalSum) {
		if (cur == null) {
			System.out.println("Empty List ! Cannot Print");
			return;
		}

		if (cur.data == curSum) {
			System.out.println("Found!");
			printPath(cur, totalSum);
		} else {
			if (cur.left != null)
				printAllPaths(cur.left, curSum - cur.data, totalSum);
			if (cur.right != null)
				printAllPaths(cur.right, curSum - cur.data, totalSum);
		}
		if (cur.left != null)
			printAllPaths(cur.left, curSum - cur.data, totalSum);
		if (cur.right != null)
			printAllPaths(cur.right, curSum - cur.data, totalSum);
	}

	private void printPath(node cur, int sum) {
		if (cur != null) {
			if (cur.data == sum) {
				System.out.println(" " + cur.data);
			} else {
				printPath(cur.parent, sum - cur.data);
			}
			System.out.println(" " + cur.data);
			return;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreewithParent tree = new TreewithParent();
		tree.insertNode(5);
		tree.insertNode(2);
		tree.insertNode(7);
		tree.insertNode(1);
		tree.insertNode(3);
		tree.insertNode(9);
		tree.bfs();
		node cur = root;
		tree.printAllPaths(cur, 5, 5);
	}

}
