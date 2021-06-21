/* implementing a binary search tree
 * of int elements
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Node {
	int data;
	struct Node *lptr;
	struct Node *rptr;
} node;

node *root;

node *createNode(int data);
void insertTree(int data);
void printInorder(node* curr);
int searchTree(int key, node *curr);

int main() {
	printf("Binary Tree.\n");

	printf("Enter natural numbers. Enter 0 to end.\n");
	int num;
	for (;;) {
		scanf("%d", &num);
		if (num == 0)
			break;
		insertTree(num);
	}

	printf("The numbers entered in order are:\n");
	printInorder(root);

	printf("Enter an item to search for.\n");
	scanf("%d", &num);
	searchTree(num, root) ? printf("Found.\n") : printf("Not found.\n");

	return 0;
}

node *createNode(int data) {
	node *new_node = (node *) malloc(sizeof(node));
	new_node->data = data;
	new_node->lptr = NULL;
	new_node->rptr = NULL;
	return new_node;
}

void insertTree(int data) {
	node *new_node = createNode(data);
	if (!root)
		root = new_node;
	else {
		node *curr = root;
		while (curr != NULL) {
			if (curr->data == data) {
				printf("Already present.\n");
				return;
			}
			else if (curr->data > data) {
				if (!curr->lptr) {
					curr->lptr = new_node;
					return;
				}
				curr = curr->lptr;
			}
			else {
				if (!curr->rptr) {
					curr->rptr = new_node;
					return;
				}
				curr = curr->rptr;
			}
		}
	}
} 


/* printing in order:
 * print the elements in ascending order
 * not in their hierarchial order in the tree
 */
void printInorder(node *curr) {
	if (!curr)
		return;
	printInorder(curr->lptr);
	printf("%d\n", curr->data);
	printInorder(curr->rptr);
}

int searchTree(int key, node *curr) {
	if (!curr)
		return 0;
	else if (key == curr->data)
		return 1;
	else
		return searchTree(key, (key > curr->data) ? curr->rptr : curr->lptr);
}
