package javaclasses;

class CommonAnsestor {
	public static void main(String[] args) {
		CommonAnsestor c = new CommonAnsestor();

		Node node1 = c.new Node(1);
		Node node2 = c.new Node(2, node1);
		Node node3 = c.new Node(3, node1);
		Node node4 = c.new Node(4, node1);
		Node node5 = c.new Node(5, node3);
		Node node6 = c.new Node(6, node3);
		Node node7 = c.new Node(7, node3);
		Node node8 = c.new Node(8, node6);
		Node node9 = c.new Node(9, node6);
		Node node10 = c.new Node(10, node7);
		Node node11 = c.new Node(11, node7);
		Node node12 = c.new Node(12, node10);
		Node node13 = c.new Node(13, node10);

		Node commonAncestor = FindLowestCommonAncestor(node2, node11);


	}

	public class Node {
		public int Number;
		public Node Parent;

		public Node(int number, Node parent) {
			super();
			Number = number;
			Parent = parent;
		}

		public Node(int i) {

		}

		public int CalculateNodeHeight() {
			return CalculateNodeHeight(this);
		}

		private int CalculateNodeHeight(Node node) {
			if (node.Parent == null) {
				return 1;
			}

			return CalculateNodeHeight(node.Parent) + 1;
		}
	}

	public static Node FindLowestCommonAncestor(Node node1, Node node2) {
		int nodeLevel1 = node1.CalculateNodeHeight();
		int nodeLevel2 = node2.CalculateNodeHeight();

		while (nodeLevel1 > 0 && nodeLevel2 > 0) {
			if (nodeLevel1 > nodeLevel2) {
				node1 = node1.Parent;
				nodeLevel1--;
			} else if (nodeLevel2 > nodeLevel1) {
				node2 = node2.Parent;
				nodeLevel2--;
			} else {
				if (node1 == node2) {
					return node1;
				}

				node1 = node1.Parent;
				node2 = node2.Parent;
				nodeLevel1--;
				nodeLevel2--;
			}
		}

		return null;
	}
}