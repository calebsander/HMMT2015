public class Theme5 {
	private static int WIDTH = 5;

	private static boolean selected(int bitmap, int column, int row) {
		return (bitmap & (0x01 << (column * WIDTH + row))) != 0;
	}
	private static int colored(int bitmap) {
		int count = 0;
		for (int i = 0; i < WIDTH * WIDTH; i++) {
			if ((bitmap & (0x01 << i)) != 0) count++;
		}
		return count;
	}
	public static void main(String[] args) {
		boolean valid;
		int maxColored = 0;
		for (int red = 0, column1, column2, row1, row2; red < 0x01 << (WIDTH * WIDTH); red++) {
			valid = true;
			for (column1 = 0; column1 < WIDTH; column1++) {
				if (!valid) continue;
				for (column2 = column1 + 1; column2 < WIDTH; column2++) {
					if (!valid) continue;
					for (row1 = 0; row1 < WIDTH; row1++) {
						if (!valid) continue;
						for (row2 = row1 + 1; row2 < WIDTH; row2++) {
							if (selected(red, column1, row1) && selected(red, column1, row2) && selected(red, column2, row1) && selected(red, column2, row2)) valid = false;
						}
					}
				}
			}
			if (valid) maxColored = Math.max(maxColored, colored(red));
		}
		System.out.println(maxColored);
	}
}