#include<stdio.h>

int digit(long int number, int k);

int main(void)
{
    long number=0l;
    int k=0;
    printf("Enter a number: ");
    scanf("%ld", &number);
    printf("Enter the k digit: ");
    scanf("%d", &k);
    if(k>9||k<1)
    {
        printf("Enter a valid k.");
        return 1;
    }
    printf("The k th digit is %d.", digit(number, k));
    return 0;
}

int digit(long number, int k)
{
    int digit=0, i=0;
    for(;i<k;i++)
    {
        digit=number%10;
        number/=10;
    }
    return digit;
}
