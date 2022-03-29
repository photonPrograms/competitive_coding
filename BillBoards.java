public class BillBoards {
	public int maxRevenue(int[] x, int[] r) {
		int n = x.length;
		int[] rev = new int[n + 1];

		rev[0] = 0;
		rev[1] = r[0];

		for (int i = 2; i < n + 1; i++) {
			rev[i] = Math.max(rev[i - 1], r[i - 1]);
			for (int j = 0; j < i; j++)
				if (x[j] < x[i - 1] - 5)
					rev[i] = Math.max(rev[i], rev[j + 1] + r[i - 1]);
			System.out.println(i + " " + x[i - 1] + " " + r[i - 1] + " " + rev[i]);
		}

		return rev[n];
	}

	public static void main(String[] args) {
		BillBoards obj = new BillBoards();
		int[] x = new int[] {6, 7, 12, 14};
		int[] r = new int[] {5, 6, 5, 1};
		System.out.println(obj.maxRevenue(x, r));
	}
}
