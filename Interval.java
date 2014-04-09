import java.util.ArrayList;
import java.util.HashMap;

public class Interval {

	public static void main(String[] args) {
		line maxLine = null;
		int maxCount = 0;

		ArrayList<line> ar = new ArrayList<line>();
		ar.add(new line(1, 6));
		ar.add(new line(2, 3));
		ar.add(new line(3, 7));
		ar.add(new line(4, 11));
		System.out.println(ar);

		int len = ar.size();
		HashMap hs = new HashMap();
		for (int i = 0; i < (len - 1); i++) {
			line l = ar.get(i);
			int count = 0;
			for (int j = i + 1; j < (len - 1); j++) {
				line l2 = ar.get(j);

				if ((l.start < l2.start) && (l.last > l2.last)) {
					count = count + 1;
				}
				if (count > maxCount) {
					maxLine = l;
					maxCount = count;
				}
			}

		}
		System.out.println("The line is " + maxLine + "   " + maxCount);
	}

}

class line {
	int start;
	int last;

	public line(int start, int last) {
		super();
		this.start = start;
		this.last = last;
	}

	@Override
	public String toString() {
		return "(" + start + "," + last + ")";
	}

}
