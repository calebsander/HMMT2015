import java.util.Arrays;

public class Team2 {
	private static class MaxColor {
		private final int index;
		private final int number;

		public MaxColor(int index, int number) {
			this.index = index;
			this.number = number;
		}
	}
	private static MaxColor findMaxColor(int[] currentCounts) {
		int nonZeroCount = 0;
		int lastNonZeroIndex = 0;
		for (int i = 0; i < currentCounts.length; i++) {
			if (currentCounts[i] != 0) {
				nonZeroCount++;
				lastNonZeroIndex = i;
			}
		}
		int[] newCounts;
		switch (nonZeroCount) {
			case 1:
				return new MaxColor(lastNonZeroIndex, currentCounts[lastNonZeroIndex]);
			case 2:
				newCounts = Arrays.copyOf(currentCounts, currentCounts.length);
				for (int i = 0; i < newCounts.length; i++) {
					if (newCounts[i] == 0) newCounts[i]++;
					else newCounts[i]--;
				}
				return findMaxColor(newCounts);
			case 3:
				MaxColor max = new MaxColor(-1, 0);
				for (int i = 0, j; i < currentCounts.length; i++) {
					newCounts = Arrays.copyOf(currentCounts, currentCounts.length);
					for (j = 0; j < newCounts.length; j++) {
						if (j == i) newCounts[j]++;
						else newCounts[j]--;
					}
					MaxColor maxColor = findMaxColor(newCounts);
					if (maxColor.number > max.number) max = maxColor;
				}
				return max;
		}
		return null; //unreachable
	}

	public static void main(String[] args) {
		final String[] colors = {"Red", "Yellow", "Blue"};
		int[] initialCounts = {3, 4, 5};
		MaxColor max = findMaxColor(initialCounts);
		System.out.println(colors[max.index] + ": " + max.number);
	}
}