/* input: a number n
 * output: the list of primes upto n
 * using the sieve of eratosthenes
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct Primes {
	int num;
	struct Primes *next;
} primes;

void sieve(int n);

int main() {
	int k, n;
	scanf("%d", &k);	// number of test cases
	for (int i = 0; i < k; i++) {
		scanf("%d", &n);
		sieve(n);
	}
	return 0;
}

void sieve(int n) {
	primes *head;
	if (n <= 1) {
		printf("No primes\n");
		return;
	}
	primes *curr = (primes *) malloc(sizeof(primes));
	curr->next = NULL;
	curr->num = 2;
	head = curr;
	for (int i = 3; i <= n; i++) {
		primes *element = (primes *) malloc(sizeof(primes));
		element->next = NULL;
		element->num = i;
		curr->next = element;
		curr = element;
	}
	for (curr = head; curr; curr = curr->next) {
		int key = curr->num;
		for (primes *el = curr->next, *prev = curr; el; prev = el, el = el->next)
			if (el->num % key == 0) {
				prev->next = el->next;
				free(el);
				el = prev;
			}
	}
	for (curr = head; curr; curr = curr->next)
		printf("%d ", curr->num);
	printf("\n");
	for (curr = head; curr; curr = curr->next)
		free(curr);
}
