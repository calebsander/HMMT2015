public class General1 {
	public static void main(String[] args) {
		int count = 0;
		for (int a = 1, b, c; a < 12; a++) {
			for (b = 1; b < 12; b++) {
				for (c = 1; c < 12; c++) {
					if (a + a * b + a * b * c == 11) count++;
				}
			}
		}
		System.out.println(count);
	}
}