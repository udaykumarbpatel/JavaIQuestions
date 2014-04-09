package javaclasses;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortLinkedList {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("abc");
		list.add("Bcd");
		list.add("aAb");
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Collator.getInstance().compare(o1, o2);
			}
		});

		System.out.println(list);
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(4);
		list1.add(2);
		list1.add(3);
		Collections.sort(list1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});

		System.out.println(list1);
	}

}
