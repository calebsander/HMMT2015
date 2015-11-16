public class General9 {
	private static class RationalNumber {
		public final int numerator, denominator;

		public RationalNumber(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
		public RationalNumber(int integer) {
			this(integer, 1);
		}

		public boolean equals(RationalNumber other) {
			return this.numerator * other.denominator == this.denominator * other.numerator;
		}
		public boolean greaterThan(RationalNumber other) {
			return this.numerator * other.denominator > this.denominator * other.numerator;
		}
		public RationalNumber multiply(RationalNumber other) {
			return new RationalNumber(this.numerator * other.numerator, this.denominator * other.denominator);
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
		public boolean isReduced() {
			boolean relativelyPrime = true;
			for (int i = 2; i <= this.denominator; i++) {
				if (this.numerator % i == 0 && this.denominator % i == 0) {
					relativelyPrime = false;
					break;
				}
			}
			return relativelyPrime;
		}
		public String toString() {
			return this.numerator + "/" + this.denominator;
		}
	}

	private static final int MAX_GAMES = 10000;

	public static void main(String[] args) {
		RationalNumber k;
		RationalNumber product = new RationalNumber(1);
		for (int n = 1, w; n <= 2015; n++) {
			for (w = 0; w < n; w++) {
				k = new RationalNumber(w, n);
				if (!k.isReduced()) continue;
				RationalNumber onWin;
				int ng = 1, wg = 0;
				boolean unreachable = true;
				for (int additionalGames = 0; additionalGames < MAX_GAMES; additionalGames++) {
					onWin = new RationalNumber(wg + 1, ng + 1);
					if (onWin.greaterThan(k)) {
						unreachable = false;
						break;
					}
					else if (!onWin.equals(k)) wg = onWin.numerator;
					ng = onWin.denominator;
				}
				if (unreachable) product = product.multiply(k).reduced();
			}
		}
		System.out.println(product);
	}
}