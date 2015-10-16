#include<stdio.h>
int main()
{
    int num=0, digitTen=0, digitUnit=0;
    printf("Enter a two-digit numbner: ");
    scanf("%d", &num);
    digitUnit=num%10;
    digitTen=(num-digitUnit)/10;
    printf("The reversal is: %d", digitUnit*10+digitTen);
}
