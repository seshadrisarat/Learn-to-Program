#include<stdio.h>
#include<stdlib.h>

struct treeNode
{
	int d;
	struct treeNode* l;
	struct treeNode* r;
};

struct treeNode* root;

struct treeNode* newNode(int data)
{
	struct treeNode *newN = (struct treeNode*) malloc(sizeof(struct treeNode));
	newN -> d = data;
	newN -> l = NULL;
	newN -> r = NULL;
	return newN;
}

void preTrav(struct treeNode* root)
{
	if(root != NULL)
	{
		printf("%d\t", root -> d);
		preTrav(root -> l);
		preTrav(root -> r);
	}
}

void postTrav(struct treeNode* root)
{
	if(root != NULL)
	{
		postTrav(root -> l);
		postTrav(root -> r);
		printf("%d\t", root -> d);
	}
}

void inTrav(struct treeNode* root)
{
	if(root != NULL)
	{
		inTrav(root -> l);
		printf("%d\t", root -> d);
		inTrav(root -> r);
	}
}

struct treeNode* insertNode(struct treeNode* root, int data)
{
	if(root == NULL)
	{
		root = newNode(data);
	}
	else
	{
		if(root -> l == NULL)
		{
			root -> l = insertNode(root -> l, data);
		}
		else
		{
			root -> r = insertNode(root -> r, data);
		}
	}
	return root;
}


int main()
{
	root = NULL;

	root = newNode(1);
	root -> l = newNode(2);
	root -> r = newNode(3);

	root -> l -> l = newNode(4);
	root -> l -> r = newNode(5);

	root -> r -> r = newNode(6);

	insertNode(root, 7);
	insertNode(root, 8);
	insertNode(root, 9);
	insertNode(root, 10);
	insertNode(root, 11);
	insertNode(root, 12);
	insertNode(root, 13);
	insertNode(root, 14);

	printf("\nPre-Order Trversal:\t");
	preTrav(root);
	printf("\nPost-Order Trversal:\t");
	postTrav(root);
	printf("\nIn-Order Trversal:\t");
	inTrav(root);
	
}