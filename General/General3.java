public class General3 {
	public static void main(String[] args) {
		int weight = 2015;
		int steps = 0;
		while (weight != 1) {
			if (weight % 2 == 0) weight /= 2;
			else weight++;
			steps++;
		}
		System.out.println(steps);
	}
}