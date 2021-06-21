/* input: any text file
 * output: the text formatted with word wrapping
 */

#include <stdio.h>
#define LIM 1000
#define N 20

void printer(char str[], int start, int max);

int main() {
	int ch, i = 0;
	char line[LIM];
	while ((ch = getchar()) != EOF) {
		line[i] = ch;
		if (ch == '\n') {
			line[i] = '\0';
			printer(line, 0, N);
			for (int j = 0; j < i; j++)
				line[j] = '\0';
			i = 0;
			continue;
		}
		i++;
	}
	return 0;
}

void printer(char str[], int start, int max) {
	int stop = max;
	int i = 0, flag = 0, len;
	for (int j = 0; j < LIM; j++)
		if (str[j] == '\0') {
			len = j;
			break;
		}
	char block1[LIM];
	char block2[LIM];
	for (int j = 0; j < LIM; j++)
		block1[j] = block2[j] = '\0';
	char ch;
	while (i < len) {
		ch = str[i];
		if (i > max) {
			int j, k;
			for (j = 0; j < stop; j++)
				block1[j] = str[j];
			block1[j] = '\0';
			printf("%s\n", block1);
			for (j = stop, k = 0; j < len; j++, k++)
				block2[k] = str[j];
			printer(block2, 0, max);
			flag = 1;
			break;
		}
		if (ch == ' ' || ch == '\t')
			stop = i + 1;
		i++;
	}
	if(!(flag))
		printf("%s\n", str);
}
