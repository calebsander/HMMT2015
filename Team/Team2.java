import java.util.Arrays;

public class Team2 {
	public static void main(String[] args) {
		final String[] colors = {"Red", "Yellow", "Blue"};
		final int[] initialCounts = {3, 4, 5};
		int[] currentCounts;
		boolean stop;
		int max = 0, maxIndex = -1;
		for (int i = 0; i < initialCounts.length; i++) {
			currentCounts = Arrays.copyOf(initialCounts, initialCounts.length);
			stop = false;
			while (!stop) {
				for (int j = 0; j < currentCounts.length; j++) {
					if (j == i) continue;
					currentCounts[j]--;
					if (currentCounts[j] == 0) stop = true;
				}
				currentCounts[i]++;
			}
			if (currentCounts[i] > max) {
				max = currentCounts[i];
				maxIndex = i;
			}
		}
		System.out.println(colors[maxIndex] + ": " + max);
	}
}