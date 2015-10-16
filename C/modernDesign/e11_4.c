#include<stdio.h>

void swap(int *p, int *q);

int main()
{
    int i=0, j=0;
    printf("Enter two number: ");
    scanf("%d %d", &i, &j);
    swap(&i, &j);
    printf("i=%d, j=%d", i, j);
}

/* swap two value, not two pointer */
void swap(int *p, int *q)
{
    int temp=0;
    temp=*p;
    *p=*q;
    *q=temp;
}
