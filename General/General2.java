public class General2 {
	private static final int RUN_COUNT = 10000000;

	public static void main(String[] args) {
		int successCount = 0;
		double a, b;
		for (int i = 0; i < RUN_COUNT; i++) {
			a = Math.random();
			b = Math.random();
			if (a + b > 1 && a + 1 > b && b + 1 > a) {
				if (a * a + b * b < 1) successCount++;
			}
		}
		System.out.println((double)successCount / RUN_COUNT);
	}
}