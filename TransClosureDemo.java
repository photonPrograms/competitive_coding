public class TransClosureDemo {
	public static void display(boolean[][] R) {
		int n = R.length;
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(R[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		/*
		boolean[][] M_R = {{false, false, false, true},
							{true, false, true, false},
							{true, false, false, true},
							{false, false, true, false}};
		*/
		int[][] M_Rint = {{0, 1, 1, 0, 1},
						{1, 0, 1, 0, 0},
						{1, 1, 0, 0, 0},
						{1, 0, 0, 0, 0},
						{1, 0, 0, 1, 0}};
		int m = M_Rint.length, n = M_Rint[0].length;
		boolean[][] M_R = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				M_R[i][j] = !(M_Rint[i][j] == 0);
		display(M_R);
		System.out.println("Regular");
		display(TransClosure.regular(M_R));
		System.out.println("Warshall");
		display(TransClosure.warshall(M_R));
	}
}
