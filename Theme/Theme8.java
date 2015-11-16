import java.util.Random;

public class Theme8 {
	private static final int RUN_COUNT = 10000000;

	private static int newPosition(int oldPosition, Random rand) {
		int position = rand.nextInt(7);
		if (position < oldPosition) return position;
		else return position + 1;
	}
	public static void main(String[] args) {
		Random rand = new Random();
		int minutesSum = 0;
		for (int i = 0; i < RUN_COUNT; i++) {
			int rookX = 0, rookY = 0;
			while (rookX != 7 || rookY != 7) {
				if (rand.nextInt() % 2 == 0) rookX = newPosition(rookX, rand);
				else rookY = newPosition(rookY, rand);
				minutesSum++;
			}
		}
		System.out.println((double)minutesSum / RUN_COUNT);
	}
}