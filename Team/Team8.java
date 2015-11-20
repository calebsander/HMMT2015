import java.math.BigInteger;

public class Team8 {
	private static final int MAX_TEST = 1000;
	private static final BigInteger MAX_PRODUCT = BigInteger.valueOf(100000);

	public static void main(String[] args) {
		BigInteger aBI, bBI, cBI, dBI;
		int compareTo;
		for (int a = 1, b, c, d; a < MAX_TEST; a++) {
			aBI = BigInteger.valueOf(a);
			for (b = 1; b < MAX_TEST; b++) {
				bBI = BigInteger.valueOf(b);
				for (c = 1; c < MAX_TEST; c++) {
					cBI = BigInteger.valueOf(c);
					if (aBI.multiply(bBI).multiply(cBI).compareTo(MAX_PRODUCT) > 0) break;
					for (d = 1; d < MAX_TEST; d++) {
						dBI = BigInteger.valueOf(d);
						compareTo = aBI.pow(3).add(bBI.pow(4)).add(cBI.pow(5)).compareTo(dBI.pow(11));
						if (compareTo < 0) break;
						if (compareTo == 0) System.out.println("(" + a + ", " + b + ", " + c + ", " + d + ")");
					}
				}
			}
		}
	}
}