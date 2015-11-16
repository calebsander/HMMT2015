import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Theme7 {
	private static final int INTEGERS = 7;

	private static class Function {
		private int[] values;
		private boolean done;

		public Function() {
			this.values = new int[INTEGERS];
			for (int i = 0; i < this.values.length; i++) values[i] = 1;
			this.done = false;
		}

		private static int nextValue(int input) {
			return input % INTEGERS + 1;
		}
		public void next() {
			this.values[0] = nextValue(this.values[0]);
			boolean reset = this.values[0] == 1;
			int origValue;
			for (int i = 1; i < this.values.length; i++) {
				origValue = this.values[i];
				if (reset) this.values[i] = nextValue(this.values[i]);
				else break;
				reset = this.values[i] < origValue;
			}
			this.done = reset;
		}
		public boolean done() {
			return this.done;
		}
		public int evaluate(int input) {
			return this.values[input - 1];
		}
		public String toString() {
			String result = "";
			for (int i = 0; i < INTEGERS; i++) result += this.values[i] + " ";
			return result;
		}
	}

	private static List<int[]> permute(int[] a, int k) {
		List<int[]> permutations = new ArrayList<int[]>();
		if (k == a.length) permutations.add(a);
		else {
			for (int i = k; i < a.length; i++) {
				int temp = a[k]
;				a[k] = a[i];
				a[i] = temp;
				permutations.addAll(permute(a, k + 1));
				temp = a[k];
				a[k] = a[i];
				a[i] = temp;
			}
		}
		return permutations;
	}
	private static List<int[]> permute(int[] a) {
		return permute(a, 0);
	}
	private static int[] process(int[] row, Function testFunction) {
		int[] nextRow = new int[row.length];
		for (int i = 0; i < row.length; i++) nextRow[i] = testFunction.evaluate(row[i]);
		return nextRow;
	}
	public static void main(String[] args) {
		Function testFunction = new Function();
		final int[] possibleNumbers = new int[INTEGERS];
		for (int i = 0; i < INTEGERS; i++) possibleNumbers[i] = i + 1;
		final List<int[]> permutations = permute(possibleNumbers);
		boolean successfulFunction;
		int successCount = 0;
		while (!testFunction.done()) {
			successfulFunction = true;
			for (int[] row : permutations) {
				List<int[]> rows = new ArrayList<int[]>();
				rows.add(row);
				int[] processedRow = row;
				for (int i = 0; i < 5; i++) {
					processedRow = process(processedRow, testFunction);
					for (int[] previousRow : rows) {
						if (Arrays.equals(previousRow, processedRow)) {
							successfulFunction = false;
							break;
						}
					}
					if (!successfulFunction) break;
					rows.add(processedRow);
				}
				processedRow = process(processedRow, testFunction);
				if (successfulFunction) successfulFunction = Arrays.equals(rows.get(0), processedRow);
				if (!successfulFunction) break;
			}
			if (successfulFunction) successCount++;
			testFunction.next();
		}
		System.out.println(successCount);
	}
}