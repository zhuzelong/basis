#include<stdio.h>
#define N 10

void find_two_largest(int a[], int n, int *largest, int *second_largest);

int main()
{
    int a[N]={0}, count=0, i=0;
    int largest=0, second_largest=0; /* look for value, not index */
    printf("Enter a series of numbers not exceeding 10 numbers: ");
    for(;i<N;i++)
    {
        scanf("%d", a+i);
        count++;
    }
    find_two_largest(a,count,&largest,&second_largest);
    for(i=0; i<N; i++)
        printf("%d ", a[i]);
    printf("The largest number is %d, the second largest number is %d.", largest, second_largest);
    return 0;
}

void find_two_largest(int a[], int n, int *largest, int *second_largest)
{
    largest=second_largest=a;
    for(int i=1; i<n; i++)
    {
        if(*(a+i)>*largest)
            *largest=*(a+i);
        if(*(a+i)>*second_largest && *(a+i)<*largest)
            *second_largest=*(a+i);
    }
}
