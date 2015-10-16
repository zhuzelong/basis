#include<stdio.h>

int gcd(int m, int n);

int main(void)
{
    int m, n;
    printf("Enter two integer: ");
    scanf("%d %d", &m, &n);
    printf("The greatest common divisor is %d.", gcd(m,n));
    return 0;
}

int gcd(int m, int n)
{
    int temp=0;
    while(n!=0)
    {
        temp=m%n;
        m=n;
        n=temp;
    }
    return m;
}
