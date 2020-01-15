/* input: two non-negative integers
 * output: their gcd using euclid's algorithm
 * lcm can be calculated using gcd
 */

#include <stdio.h>
#define MAX(a, b) a >= b ? a : b
#define MIN(a, b) a < b ? a : b

int gcd(int a, int b);

int main() {
	int k;	// number of test cases
	int a, b;
	scanf("%d", &k);
	for (int i = 0; i < k; i++) {
		scanf("%d %d", &a, &b);
		printf("%d\n", gcd(MAX(a, b), MIN(a, b)));
	}
	return 0;
}

int gcd(int a, int b) {
	if (!b)
		return a;
	a %= b;
	return gcd(b, a);
}

/*
int lcm(int a, int b, int hcf) {
	return a * b / hcf;
}
 */
