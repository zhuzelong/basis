#include<stdio.h>
int main()
{
    int m=0, n=0;
    printf("Enter two integer: ");
    scanf("%d %d", &m, &n);
    while(n!=0)
    {
        int temp=m%n;
        m=n;
        n=temp;
    }
    printf("Greatest common divisor: %d", m);
}

