import java.util.HashSet;

public class Team9 {
	private static class RationalNumber {
		public final int numerator, denominator;

		public RationalNumber(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}

		public RationalNumber reduced() {
			int numerator = this.numerator;
			int denominator = this.denominator;
			for (int i = 2; i <= denominator; i++) {
				while (numerator % i == 0 && denominator % i == 0) {
					numerator /= i;
					denominator /= i;
				}
			}
			return new RationalNumber(numerator, denominator);
		}
		public String toString() {
			return this.numerator + "/" + this.denominator;
		}
	}

	private static class Edge {
		private final int vertex1, vertex2;

		public Edge(int vertex1, int vertex2) {
			this.vertex1 = vertex1;
			this.vertex2 = vertex2;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Edge)) return false;
			final Edge otherEdge = (Edge)o;
			return (otherEdge.vertex1 == this.vertex1 && otherEdge.vertex2 == this.vertex2) || (otherEdge.vertex1 == this.vertex2 && otherEdge.vertex2 == this.vertex1);
		}
		public int hashCode() {
			return this.vertex1 * this.vertex2 + this.vertex1 + this.vertex2;
		}
		public String toString() {
			return "<" + vertex1 + "," + vertex2 + ">";
		}
	}

	private static int edgeCount(HashSet<Edge> edges, int vertex) {
		int edgeCount = 0;
		for (int otherVertex = 0; otherVertex < 6; otherVertex++) {
			if (otherVertex == vertex) continue;
			if (edges.contains(new Edge(vertex, otherVertex))) edgeCount++;
		}
		return edgeCount;
	}
	private static void allConnected(HashSet<Edge> edges, int vertex, HashSet<Integer> alreadyFound) {
		for (int i = 0; i < 6; i++) {
			if (i == vertex || alreadyFound.contains(i)) continue;
			if (edges.contains(new Edge(vertex, i))) {
				alreadyFound.add(i);
				allConnected(edges, i, alreadyFound);
			}
		}
	}
	private static HashSet<Integer> allConnected(HashSet<Edge> edges, int vertex) {
		HashSet<Integer> connected = new HashSet<Integer>();
		allConnected(edges, vertex, connected);
		return connected;
	}
	public static void main(String[] args) {
		HashSet<Edge> edges;
		int successCount = 0;
		int edgeBitMap;
		for (edgeBitMap = 0; edgeBitMap < 0x01 << 15; edgeBitMap++) {
			edges = new HashSet<Edge>();
			int bit = 0;
			for (int vertex1 = 0, vertex2; vertex1 < 5; vertex1++) {
				for (vertex2 = vertex1 + 1; vertex2 < 6; vertex2++) {
					if ((edgeBitMap & (0x01 << bit)) != 0) edges.add(new Edge(vertex1, vertex2));
					bit++;
				}
			}
			boolean satisfied = true;
			for (int vertex = 0, otherVertex; vertex < 6; vertex++) {
				int edgeCount = edgeCount(edges, vertex);
				if (edgeCount % 2 == 1) {
					satisfied = false;
					break;
				}
				if (edgeCount != 0) {
					HashSet<Integer> connectedVertices = allConnected(edges, vertex);
					for (otherVertex = 0; otherVertex < 6; otherVertex++) {
						if (!connectedVertices.contains(otherVertex) && edgeCount(edges, otherVertex) != 0) {
							satisfied = false;
							break;
						}
					}
				}
			}
			if (satisfied) successCount++;
		}
		System.out.println(new RationalNumber(successCount, edgeBitMap).reduced());
	}
}