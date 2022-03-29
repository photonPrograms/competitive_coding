// q6
public class BuySell {
	public int[] optimalBuySell(int[] p) {
		int n = p.length;
		int[] profits = new int[n];
		int[][] days = new int[n][2];
		int maxPrice = p[n - 1], maxPriceInd = n - 1;
		profits[n - 1] = 0;
		days[n - 1][0] = n - 1;
		days[n - 1][1] = n - 1;

		System.out.println("n\tdiff\tprofit\tbuy\tsell\tmaxInd");
		System.out.println(n + "\t" + 0 + "\t" + 0 + "\t" + days[n - 1][0]
				+ "\t" + days[n - 1][1] + "\t" + maxPriceInd);

		for (int i = n - 2; i >= 0; i--) {
			if (maxPrice - p[i] > profits[i + 1]) {
				profits[i] = maxPrice - p[i];
				days[i][0] = i;
				days[i][1] = maxPriceInd;
			}
			else {
				profits[i] = profits[i + 1];
				days[i][0] = days[i + 1][0];
				days[i][1] = days[i + 1][1];
			}
			if (p[i] > maxPrice) {
				maxPrice = p[i];
				maxPriceInd = i;
			}
			System.out.println((i + 1) + "\t" + (maxPrice - p[i]) + "\t" + profits[i] + "\t" + days[i][0] + "\t" + days[i][1] + "\t" + maxPriceInd);

		}
		
		if (days[0][0] == days[0][1])
			System.out.println("No way to make money");

		System.out.println("\n\n");

		return days[0];
	}

	public static void main(String[] args) {
		BuySell obj = new BuySell();
		int[] p1 = new int[] {83, 18, 34, 2, 71, 26, 44, 46, 48, 75};
		int[] p2 = new int[] {83, 75, 71, 48, 46, 44, 34, 26, 18, 2};
		obj.optimalBuySell(p1);
		obj.optimalBuySell(p2);
	}
}
