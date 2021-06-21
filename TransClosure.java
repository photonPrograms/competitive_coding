/* a collection of static methods to find the transitive closure
 * of a binary relation given in matrix representation
 */

public class TransClosure {
	public static boolean[][] regular(boolean[][] M_R) {
		// M_R: true-false matrix for the relation
		// returns B the transitive closure
		// with union of compositions
		int n = M_R.length;
		boolean[][] A = new boolean[n][n];
		boolean[][] B = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = B[i][j] = M_R[i][j];
		for (int i = 1; i <= n; i++)
			A = RelOper.compose(A, M_R);
			B = RelOper.union(B, A);
		return B;
	}

	public static boolean[][] warshall(boolean[][] M_R) {
		// M_R: true-false matrix for the relation
		// returns W the transitive closure
		// with Warshall's algorithm
		int n = M_R.length;
		boolean[][] W = M_R;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					W[i][j] = W[i][j] || (W[i][k] && W[k][j]);
			display(W);
		}
		return W;
	}

	public static void display(boolean[][] R) {
		int n = R.length;
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(R[i][j] + " ");
			System.out.println();
		}
	}
}
