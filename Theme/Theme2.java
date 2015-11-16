public class Theme2 {
	public static void main(String[] args) {
		int eightSum;
		int min = Integer.MAX_VALUE;
		for (int i = 1, j, k, l; i < 2015; i++) {
			for (j = 1; j < 2015; j++) {
				for (k = 1; k < 2015; k++) {
					for (l = 1; l < 2015; l++) {
						eightSum = i + j + k + l + (i + k) + (j + l) + (i * j) + (k * l);
						if (eightSum == 2015) min = Math.min(min, i + j + k + l);
						else if (eightSum > 2015) break;
					}
				}
			}
		}
		System.out.println(min);
	}
}