import java.math.BigInteger;
import java.util.HashSet;

public class Team10 {
	private static final int MAX_TEST = 5000;

	public static void main(String[] args) {
		HashSet<Integer> possibleRemainders;
		int count = 0;
		for (int n = 2; n < 43; n++) {
			possibleRemainders = new HashSet<Integer>();
			for (int x = 0; x < MAX_TEST; x++) {
				possibleRemainders.add(BigInteger.valueOf(x).pow(x).mod(BigInteger.valueOf(n)).intValue());
				if (possibleRemainders.size() == n) break;
			}
			if (possibleRemainders.size() != n) count++;
		}
		System.out.println(count);
	}
}