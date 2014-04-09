package javaclasses;

import java.util.ArrayList;

public class ZeroArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {0,0,2,3,3,3,3,4,7,7,9};
		ArrayList<Integer> c = new ArrayList<Integer>();
		for(int i=0; i< arr.length; i++)
		{
			c.add(arr[i]);
		}
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(5);
		a.add(3);
		a.add(9);
		a.add(0);
		a.add(0);
		a.add(3);
		a.add(3);
		a.add(0);
		a.add(3);
		a.add(0);
		a.add(3);
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != 0) {
				b.add(a.get(i));
			}
		}
		for (int i = b.size(); i < a.size(); i++) {
			b.add(0);
		}
		System.out.println(b + " \n" + 
				b.indexOf(3) + " " +
				b.lastIndexOf(3));
		
		System.out.println(c.indexOf(3) + " " +
				c.lastIndexOf(3));
		
	}
	


}
