/* input: a string
 * output: all the permutations of the characters of the string
 */

import java.io.*;
public class permutations {

	/* the recursive method output has been 'overloaded' */

	//handles the original string input
	public void output(String str) {
		int n = str.length();
		if (n == 1)
			System.out.println(str);
		else
			for (int i = 0; i < n; i++) {
				String sub1 = "", sub2 = "";
				for (int j = 0; j < n; j++)
					if (j == i)
						sub1 = sub1 + str.charAt(j);
					else
						sub2 = sub2 + str.charAt(j);
				output(sub1, sub2);
			}
	}

	// handles the subsequent inputs due to recursion
	public void output(String str1, String str2) {
		int n = str2.length();
		if (n == 1)
			System.out.println(str1 + str2);
		else
			for (int i = 0; i < n; i++) {
				String sub1 = str1, sub2 = "";
				for (int j = 0; j < n; j++)
					if (j == i)
						sub1 = sub1 + str2.charAt(j);
					else
						sub2 = sub2 + str2.charAt(j);
				output(sub1, sub2);
			}
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(reader);
		permutations obj = new permutations();

		System.out.println("Enter the string.");
		String str = buf.readLine();

		obj.output(str);
	}
}
