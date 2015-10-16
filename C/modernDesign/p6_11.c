#include<stdio.h>
int main()
{
    int n=0;
    double e=1;
    printf("Enter the accuracy: ");
    scanf("%d", &n);
    if(n<=0)
    {
        printf("Please enter a natural integer.");
        return 0;
    }
    int factorial(int);
    for(int i=1;i<=n;i++)
        e+=1/factorial(i);
        printf("%d\n", factorial(n));
    printf("e is: %f", e);
}

int factorial(int n)
{
    int i=0, product=1;
    for(i=1;i<=n;i++)
        product*=i;
    return product;
}
