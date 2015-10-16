#include<stdio.h>
int main()
{
    float number=1.0f, max=0.0f;
    while(number>0)
    {
        printf("Enter a number: ");
        scanf("%f", &number);
        if(number>max)
            max=number;
    }
    printf("The largest number entered was %f.", max);
}
