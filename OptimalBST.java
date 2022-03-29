import java.util.*;

public class OptimalBST {
	int numKeys;
	double[] keyProbs;
	double[] failProbs;

	double[][] expectedCosts;
	double[][] weights;
	int[][] roots;

	public OptimalBST(int numKeys) {
		this.numKeys = numKeys;
		keyProbs = new double[numKeys + 1];
		failProbs = new double[numKeys + 1];
		expectedCosts = new double[numKeys + 2][numKeys + 1];
		weights = new double[numKeys + 2][numKeys + 1];

		for (int i = 0; i < numKeys + 2; i++) {
			Arrays.fill(expectedCosts[i], Double.MAX_VALUE);
			Arrays.fill(weights[i], Double.MAX_VALUE);
		}

		roots = new int[numKeys + 1][numKeys + 1];
	}

	public void populateProbs(double keyProbs[], double failProbs[]) {
		for (int i = 0; i < numKeys; i++)
			this.keyProbs[i + 1] = keyProbs[i];
		for (int i = 0; i < numKeys + 1; i++)
			this.failProbs[i] = failProbs[i];
	}

	public void computeBST() {
		for (int i = 1; i <= numKeys + 1; i++) {
			expectedCosts[i][i - 1] = failProbs[i - 1];
			weights[i][i - 1] = failProbs[i - 1];
		}
		for (int l = 1; l <= numKeys; l++) {
			for (int i = 1; i <= numKeys - l + 1; i++) {
				int j = i + l - 1;
				expectedCosts[i][j] = Double.MAX_VALUE;
				weights[i][j] = weights[i][j - 1] +
					keyProbs[j] + failProbs[j];
				for (int r = i; r <= j; r++) {
					double t = expectedCosts[i][r - 1] 
						+ expectedCosts[r + 1][j] + weights[i][j];
					if (t < expectedCosts[i][j]) {
						expectedCosts[i][j] = t;
						roots[i][j] = r;
					}
				}
			}
		}
	}

	public void printResults() {
		System.out.println("Expected Costs");
		for (int i = 1; i <= numKeys + 1; i++) {
			for (int j = 0; j <= numKeys; j++)
				System.out.print(expectedCosts[i][j] + " ");
			System.out.println();
		}

		System.out.println("Weights");
		for (int i = 1; i <= numKeys + 1; i++) {
			for (int j = 0; j <= numKeys; j++)
				System.out.print(weights[i][j] + " ");
			System.out.println();
		}

		System.out.println("Roots");
		for (int i = 1; i <= numKeys; i++) {
			for (int j = 1; j <= numKeys; j++)
				System.out.print(roots[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		/*
		OptimalBST obj = new OptimalBST(5);
		obj.populateProbs(new double[] {0.15, 0.10, 0.05, 0.10, 0.20},
				new double[] {0.05, 0.10, 0.05, 0.05, 0.05, 0.10});
		*/
		OptimalBST obj = new OptimalBST(4);
		obj.populateProbs(new double[] {0.0625, 0.0625, 0.1875, 0.1875},
				new double[] {0.0625, 0.0625, 0.125, 0.1875, 0.0625});
		obj.computeBST();
		obj.printResults();
	}
}
