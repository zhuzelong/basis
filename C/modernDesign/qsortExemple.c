#include<stdio.h>
#define N 10

void quicksort(int a[], int low, int high);
int split(int a[], int low, int high);

int main(void)
{
    int a[N], i;
    printf("Enter %d numbers to be sorted: ", N);
    for(i=0; i<N; i++)
        scanf("%d", &a[i]);

    quicksort(a, 0, N-1);

    printf("In sorted order: ");
    for(i=0; i<N; i++)
        printf("%d ", a[i]);
    printf("\n");
        return 0;
}

void quicksort(int a[], int low, int high)
{
    int mid;
    if(low>=high)
        return;
    mid=split(a, low, high);
    quicksort(a, low, mid-1);
    quicksort(a, mid+1, high);
}

int split(int a[], int low, int high)
{
    int temp=a[low];
    for(;;)
    {
        while(low<high && temp<=a[high])
            high--;
        if(low>high)
            break;
        a[low]=a[high];
        while(low<high && temp>=a[low])
            low++;
        if(low>=high)
            break;
        a[high]=a[low];
    }
    a[high]=temp;
    return high;
}
