import java.math.BigInteger;
import java.util.ArrayList;

public class Team4 {
	private static boolean isGood(int max) {
		ArrayList<Integer> s = new ArrayList<Integer>(), t = new ArrayList<Integer>();
		boolean eachSetIsBad = true;
		for (long selectedForS = 0; selectedForS < (0x01 << (max - 1)); selectedForS++) {
			s.clear();
			t.clear();
			for (int bit = 0; bit < max - 1; bit++) {
				if ((selectedForS & (0x01 << bit)) != 0) s.add(bit + 2);
				else t.add(bit + 2);
			}
			boolean setIsGood = true;
			for (int a = 0, b, c; a < s.size(); a++) {
				for (b = 0; b < s.size(); b++) {
					for (c = 0; c < s.size(); c++) {
						if (c == a || c == b) continue;
						if (BigInteger.valueOf(s.get(a)).pow(s.get(b)).equals(BigInteger.valueOf(s.get(c)))) {
							setIsGood = false;
							break;
						}
					}
					if (!setIsGood) break;
				}
				if (!setIsGood) break;
			}
			for (int a = 0, b, c; a < t.size(); a++) {
				if (!setIsGood) break;
				for (b = 0; b < t.size(); b++) {
					if (!setIsGood) break;
					for (c = 0; c < t.size(); c++) {
						if (c == a || c == b) continue;
						if (BigInteger.valueOf(t.get(a)).pow(t.get(b)).equals(BigInteger.valueOf(t.get(c)))) {
							setIsGood = false;
							break;
						}
					}
				}
			}
			if (setIsGood) {
				eachSetIsBad = false;
				break;
			}
		}
		return !eachSetIsBad;
	}
	public static void main(String[] args) {
		for (int test = 2; test < 66; test++) {
			if (!isGood(test)) {
				System.out.println(test);
				break;
			}
		}
	}
}