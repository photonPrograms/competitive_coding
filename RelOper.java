/* relation operators for finding union, intersection, and composition
 * with relations given in matrix form
 * assuming relations on a single set of size n
 */

public class RelOper {
	public static boolean[][] union(boolean[][] A, boolean[][] B) {
		// union of relations A and B
		int n = A.length;
		boolean res[][] = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				res[i][j] = A[i][j] || B[i][j];
		return res;
	}
	
	public static boolean[][] intersection(boolean[][] A, boolean[][] B) {
		// intersection of relations A and B
		int n = A.length;
		boolean res[][] = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				res[i][j] = A[i][j] && B[i][j];
		return res;
	}

	public static boolean[][] compose(boolean[][] A, boolean[][] B) {
		// return A o B
		int n = A.length;
		boolean res[][] = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				res[i][j] = false;
				for (int k = 0; k < n; k++)
					res[i][j] = res[i][j] || (A[i][k] && B[k][j]);
			}
		return res;
	}
}
