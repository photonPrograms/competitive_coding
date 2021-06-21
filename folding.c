/* to fold long lines exceeding column number n
 * providing the word wrap feature
 * neglecting tabs
 */

#include <stdio.h>

#define N 70

main() {
	int col_count = 0, i = 0, j, ch, flag = 0;
	char word[N];

	while ((ch = getchar()) != EOF) {
		switch(ch) {
			case '\n':
			case ' ':
			case '\t':
				if (flag) {
					putchar('\n');
					flag = 0;
					col_count = 0;
				}
				for (j = 0; j < i; j++) {
					putchar(word[j]);
					word[j] = '\0';
				}
				i = 0;
				if (col_count >= N || ch == '\n') {
					col_count = 0;
					putchar('\n');
				}
				else
					putchar(ch);
				break;
			default:
				word[i] = ch;
				i++;
				if (col_count > N)
					flag = 1;
		}
	}
}
