public class Theme6 {
	private static class RationalNumber {
		public final int numerator, denominator;

		public RationalNumber(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}

		public RationalNumber reduced() {
			int numerator = this.numerator;
			int denominator = this.denominator;
			for (int i = 2; i <= denominator; i++) {
				while (numerator % i == 0 && denominator % i == 0) {
					numerator /= i;
					denominator /= i;
				}
			}
			return new RationalNumber(numerator, denominator);
		}
		public String toString() {
			return this.numerator + "/" + this.denominator;
		}
	}

	public static void main(String[] args) {
		int squareCount = 0;
		for (int i = 0, j; i < 6; i++) {
			for (j = 1; i + j < 6; j++) {
				if (i == 0 && j == 0) continue;
				squareCount += Math.pow(6 - (i + j), 2);
			}
		}
		final int totalCount = (36 * 35 * 34 * 33) / (4 * 3 * 2);
		System.out.println(new RationalNumber(squareCount, totalCount).reduced());
	}
}