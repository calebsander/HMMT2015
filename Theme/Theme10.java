import java.util.Random;

public class Theme10 {
	private static final int RUN_COUNT = 10000000;

	private static class Square {
		private static final int WIDTH = 10;
		private static Random rand = new Random();

		private int x, y;

		public Square(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void moveAdjacentTowards(Square other) {
			if (this.x == other.x) this.y += Math.signum(other.y - this.y);
			else {
				if (this.y == other.y) this.x += Math.signum(other.x - this.x);
				else {
					if (rand.nextBoolean()) this.x += Math.signum(other.x - this.x);
					else this.y += Math.signum(other.y - this.y);
				}
			}
		}
		public void randomSquare() {
			this.x = rand.nextInt(WIDTH);
			this.y = rand.nextInt(WIDTH);
		}
		public boolean equals(Square other) {
			return this.x == other.x && this.y == other.y;
		}
	}
	public static void main(String[] args) {
		int totalMoves = 0;
		for (int i = 0; i < RUN_COUNT; i++) {
			Square burritoSquare = new Square(0, 0);
			Square pigeonSquare = new Square(0, 0);
			int burritoRemaining = 10;
			while (burritoRemaining != 0) {
				if (burritoSquare.equals(pigeonSquare)) {
					burritoRemaining--;
					burritoSquare.randomSquare();
				}
				else pigeonSquare.moveAdjacentTowards(burritoSquare);
				totalMoves++;
			}
		}
		System.out.println((double)totalMoves / RUN_COUNT);
	}
}