import java.util.ArrayList;

public class General5 {
	private final static int MAX_NUMBER = 2015;

	private static int mod(int a, int b) {
		return (a % b + b) % b;
	}
	public static void main(String[] args) {
		ArrayList<Integer> s = new ArrayList<Integer>(MAX_NUMBER);
		for (int element = 1; element <= 2015; element += 3) s.add(element);
		for (int a = 0, b; a < s.size(); a++) {
			for (b = a + 1; b < s.size(); b++) {
				if (mod((s.get(a) + s.get(b)), (s.get(a) - s.get(b))) == 0) System.out.println("Doesn't work: " + s.get(a) + ", " + s.get(b));
			}
		}
		System.out.println(s.size());
	}
}