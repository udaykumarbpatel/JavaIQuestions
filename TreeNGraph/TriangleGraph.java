package javaclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TriangleGraph {
	public HashMap<Integer, LinkedList<Integer>> maplist = new HashMap<Integer, LinkedList<Integer>>();
	public Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

	public void createList(int from, int to) {

		if (!maplist.containsKey(from)) {
			maplist.put(from, new LinkedList<Integer>());
			LinkedList<Integer> l = maplist.get(from);
			l.add(to);
		} else {
			LinkedList<Integer> l = maplist.get(from);
			l.add(to);
		}

		if (!maplist.containsKey(to)) {
			maplist.put(to, new LinkedList<Integer>());
			LinkedList<Integer> l = maplist.get(to);
			l.add(from);
		} else {
			LinkedList<Integer> l = maplist.get(to);
			l.add(from);
		}
	}

	public void displayAdjList() {
		Iterator itr = maplist.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry pairs = (Map.Entry) itr.next();
			System.out.println("Node:" + pairs.getKey() + "  List:"
					+ pairs.getValue());
		}
	}

	public int numberOfTriangles() {
		int count = 0;
		for (int key : maplist.keySet()) {
			HashSet<Integer> list = new HashSet<Integer>();
			LinkedList<Integer> l = maplist.get(key);
			for (Integer item : l) {
				list.add(item);
			}

			for (Integer item : l) {
				LinkedList<Integer> m = maplist.get(item);
				for (Integer item1 : m) {
					if (list.contains(item1)) {
						count++;
					}
				}
			}
		}
		return count/6;

	}

	public static void main(String[] args) throws IOException {
		TriangleGraph t = new TriangleGraph();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many inputs :  ");
		int num1 = Integer.parseInt(br.readLine());

		for (int i = 0; i < num1; i++) {
			System.out.println("Enter from and to  :  ");
			int from = Integer.parseInt(br.readLine());
			int to = Integer.parseInt(br.readLine());
			t.createList(from, to);
		}

		t.displayAdjList();
		int num = t.numberOfTriangles();
		System.out.println(num);
	}
}
