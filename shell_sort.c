/* input: an array of integers of values upto 100000
 * output: the array sorted in ascending order
 * using shell sort
 */

#include <stdio.h>
#define LIM 100

void insertionSort(int a[], int g, int n);
void shellSort(int a[], int n);

int main() {
	int arr[LIM], i = 0, num;
	printf("Enter the array elements. Press 100000 to end.\n");
	scanf("%d", &num);
	while (num != 100000) {
		arr[i++] = num;
		scanf("%d", &num);
	}

	shellSort(arr, i);
	
	for (int j = 0; j < i; j++)
		printf("%d\n", arr[j]);

	return 0;
}

void shellSort(int a[], int n) {
	int gap = n / 2;
	while (gap > 0) {
		insertionSort(a, gap, n);
		gap /= 2;
	}
}

void insertionSort(int a[], int g, int n) {
	for (int i = g; i < n; i += g) {
		int key = a[i];
		for (int j = i - g; j >= 0; j -= g)
			if (a[j] > key) {
				a[j + g] = a[j];
				a[j] = key;
			}
			else
				break;
	}
}
