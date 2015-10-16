#include<stdio.h>
int main(void)
{
    int num1=0, denum1=0, num2=0, denum2=0;
    printf("Please enter two fractions separated by +:");
    scanf("%d/%d+%d/%d",&num1,&denum1,&num2,&denum2);
    printf("The sum is: %d/%d\n",num1*denum2+num2*denum1, denum1*denum2);
    return 0;
}
