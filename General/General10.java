//Not even computable
public class General10 {
	private static final int INTEGERS = 101;

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
	}

	public static void main(String[] args) {
		int n = 0;
		Function testFunction = new Function();
		int value, i;
		while (!testFunction.done()) {
			value = 1;
			for (i = 0; i < INTEGERS; i++) value = testFunction.evaluate(value);
			if (value == 2) {
				n++;
				if (n % 10000 == 0) System.out.println(n);
				if (n == Integer.MAX_VALUE) System.out.println("Max exceded");
			}
			testFunction.next();
		}
		System.out.println(n % 103);
	}
}