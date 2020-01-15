/* input: k number of test cases, each a natural number n
 * output: the prime factorization of the number
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct Primes {
	int num;
	struct Primes *next;
} primes;

void factorize(int n);
primes *sieve(int n);
void cleaner(primes *head);

int main() {
	int k, n;
	scanf("%d", &k);
	for (int i = 0; i < k; i++) {
		scanf("%d", &n);
		factorize(n);
	}
	return 0;
}

void factorize(int n) {
	primes *head = sieve(n);
	if (!head)
		printf("%d\n", n);
	else {
		for (primes *curr = head; curr; curr = curr->next) {
			int exponent = 0;
			while (n % curr->num == 0) {
				n /= curr->num;
				exponent++;
			}
			if (exponent)
				printf("%d^%d * ", curr->num, exponent);
		}
		printf("1\n");
	}
	cleaner(head);
}

primes *sieve(int n) {
	primes *head;
	if (n <= 1)
		return NULL;
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
	return head;
}

void cleaner(primes *head) {
	primes *curr, *prev;
	prev = curr =head;
	while (curr) {
		prev = curr;
		curr = curr->next;
		free(prev);
	}
}
