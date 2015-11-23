import java.util.ArrayList;
import java.util.Arrays;

public class Theme9 {
	private static final int ROWS = 9;
	private static final int SUBSQUARE_SIZE = 3;

	private static ArrayList<int[]> permutations(int[] a) {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		permutation(a, 0, ret);
		return ret;
	}

	private static void permutation(int[] arr, int pos, ArrayList<int[]> list) {
		if (arr.length - pos == 1) list.add(arr.clone());
		else {
			for (int i = pos; i < arr.length; i++){
				swap(arr, pos, i);
				permutation(arr, pos + 1, list);
				swap(arr, pos, i);
			}
		}
	}
	private static void swap(int[] arr, int pos1, int pos2) {
		int h = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = h;
	}
	public static void main(String[] args) {
		int[] possibleRows = new int[ROWS];
		for (int i = 0; i < ROWS; i++) possibleRows[i] = i;
		final ArrayList<int[]> onePositionsPossibilities = permutations(possibleRows);
		boolean everSuccessful = false;
		for (int[] positions : onePositionsPossibilities) {
			boolean success = true;
			for (int i = 0, j, k, l; i < ROWS - SUBSQUARE_SIZE + 1; i++) {
				for (j = 0; j < ROWS - SUBSQUARE_SIZE + 1; j++) {
					int count = 0;
					for (k = 0; k < SUBSQUARE_SIZE; k++) {
						for (l = 0; l < SUBSQUARE_SIZE; l++) {
							if (positions[i + k] == j + l) count++;
							if (count > 1) {
								success = false;
								break;
							}
						}
						if (!success) break;
					}
					if (count == 0) success = false;
					if (!success) break;
				}
				if (!success) break;
			}
			if (success) everSuccessful = true;
		}
		if (everSuccessful) System.out.println("Possible solutions");
		else System.out.println("No possible solutions");
	}
}