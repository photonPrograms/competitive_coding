/* input:
 * array size n
 * and array elements with values between (1 and 9 inclusive)
 */

/* output:
 * number of codes the array could point to
 * with each sequence of digits between 1 and 26
 * mapping to a letter of the English alphabet
 */

import java.io.*;
public class numCodings {
	public int calc(int a[], int start) {
		// start stores the start index to investigate the array from
		int l = a.length, count = 0;
		if (start == l || start == l - 1)
			return 1;
		else {
			count = 1;
			for (int i = start; i < l; i++)
				if (i + 1 < l)
					if (a[i]*10 + a[i+1] <= 26)
						count += calc(a, i + 2);
			return count;
		}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(reader);

		System.out.println("Enter the array size n.");
		int n = Integer.parseInt(buf.readLine());	//stores the number of array elements

		int arr[] = new int[n];	//stores the code to decode
		System.out.println("Enter the array elements.");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(buf.readLine());

		numCodings obj = new numCodings();
		int count = 1; //stores the number of valid decodings possible
		//initial count 1 to account for case no digit seq are made
		for (int i = 0; i < n; i++)
			if (i + 1 < n)
				if (arr[i]*10 + arr[i+1] <= 26)
					count += obj.calc(arr, i + 2);

		System.out.println("The total number of decodings is " + count);
	}
}
