#include<stdio.h>
#include<math.h>
#define BOUND 0.00001
int main()
{
    double number=0.0, predictValue=0, root=1.0, quotient=0.0, avg=0.0;
    printf("Enter a positive number: ");
    scanf("%lf", &number);
    if(number<=0.0)
    {
        printf("Please enter a positive number.");
        return 0;
    }
    while(fabs(predictValue-root)>=BOUND*root)
    {
        predictValue=root;
        quotient=number/root;
        avg=(quotient+root)/2.0;
        root=avg;
    }
    printf("Square root: %g", root);
}

