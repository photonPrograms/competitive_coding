/* input: a list of non-negative integers
 * output: the linked list after performing a multitude of operations on it
 */

#include <stdio.h>
#include <stdlib.h>

void insertEnd(int num);
void printList();
void deleteNode(int num);
void insertFirst(int num);
void sortAscending();

typedef struct Node {
	int data;
	struct Node *next;
} node;

node *head = NULL;

int main() {
	int num;

	printf("Enter numbers; enter a negative number to end.\n");
	while(1) {
		scanf("%d", &num);
		if (num < 0)
			break;
		insertEnd(num);
	}

	printf("The linked list is:\n");
	printList();

	printf("Enter the data value to be deleted.\n");
	scanf("%d", &num);
	deleteNode(num);
	printList();

	printf("Enter the value to be inserted first.\n");
	scanf("%d", &num);
	insertFirst(num);
	printList();

	sortAscending();
	printList();

	return 0;
}

void insertEnd(int num) {
	node *new = (node *) malloc(sizeof(node));

	if (new == NULL) {
		printf("memory allocation error\n");
		exit(1);
	}

	new->next = NULL;
	new->data = num;

	if (head == NULL) {
		head = new;
		return;
	}

	node *cur = head;
	while (cur->next != NULL)
		cur = cur->next;
	cur->next = new;
}

void printList() {
	node *cur = head;
	while (cur->next != NULL) {
		printf("%d => ", cur->data);
		cur = cur->next;
	}
	printf("%d", cur->data);
	printf("\n");
}

void deleteNode(int num) {
	node *cur = head, *prev;
	
	while (cur->data == num) {
		head = cur->next;
		free(cur);
		cur = head;
	}

	if (head == NULL)
		return;

	prev = cur;
	cur = cur->next;
	while (cur->next != NULL) {
		if (cur->data == num) {
			prev->next = cur->next;
			free(cur);
			cur = prev->next;
			continue;
		}
		prev = cur;
		cur = cur->next;
	}

	if (cur->data == num) {
		prev->next = NULL;
		free(cur);
	}
}

void insertFirst(int num) {
	node *new = malloc(sizeof(node));
	new->data = num;

	if (!head) {
		head = new;
		new->next = NULL;
		return;
	}

	new->next = head;
	head = new;
}

void sortAscending() {
	node *cur1, *cur2, *tptr;
	int temp, min;
	
	cur1 = head;

	while (cur1->next) {
		cur2 = cur1;
		min = cur1->data;
		tptr = cur1;
		while (cur2->next) {
			if (cur2->data < min) {
				min = cur2->data;
				tptr = cur2;
			}
			cur2 = cur2->next;
		}

		if (cur2->data < min) {
			min = cur2->data;
			tptr = cur2;
		}

		temp = tptr->data;
		tptr->data = cur1->data;
		cur1->data = temp;
		cur1 = cur1->next;
	}
}
