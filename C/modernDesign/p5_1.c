#include<stdio.h>
int main()
{
    int number=0;
    int digit=0;
    printf("Enter a number: ");
    scanf("%d", &number);
    if(number<10)
        digit=1;
    else if(number<100)
        digit=2;
    else if(number<1000)
        digit=3;
    else digit=4;
    printf("The number %d has %d digits.", number, digit);
}
