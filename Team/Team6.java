import java.util.ArrayList;

public class Team6 {
	private static class Friendship {
		public final int person1, person2;

		public Friendship(int person1, int person2) {
			this.person1 = person1;
			this.person2 = person2;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Friendship)) return false;
			final Friendship otherFriendship = (Friendship)o;
			return (otherFriendship.person1 == this.person1 && otherFriendship.person2 == this.person2) || (otherFriendship.person1 == this.person2 && otherFriendship.person2 == this.person1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Friendship> friendships;
		int successCount = 0;
		for (int friendBitMap = 0; friendBitMap < 0x01 << 10; friendBitMap++) {
			friendships = new ArrayList<Friendship>();
			int bit = 0;
			for (int person1 = 0, person2; person1 < 4; person1++) {
				for (person2 = person1 + 1; person2 < 5; person2++) {
					if ((friendBitMap & (0x01 << bit)) != 0) friendships.add(new Friendship(person1, person2));
					bit++;
				}
			}
			boolean satisfied = true;
			for (int person1 = 0, person2; person1 < 4; person1++) {
				for (person2 = person1 + 1; person2 < 5; person2++) {
					if (!friendships.contains(new Friendship(person1, person2))) { //if they are enemies
						for (int person3 = 0; person3 < 5; person3++) {
							if (person3 == person1 || person3 == person2) continue;
							if (friendships.contains(new Friendship(person1, person3)) && friendships.contains(new Friendship(person2, person3))) {
								satisfied = false;
								break;
							}
						}
					}
					if (!satisfied) break;
				}
				if (!satisfied) break;
			}
			if (satisfied) successCount++;
		}
		System.out.println(successCount);
	}
}