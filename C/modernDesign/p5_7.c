#include<stdio.h>
int main()
{
    int num1=0, num2=0, num3=0, num4=0;
    int max=0, min=0;
    printf("Enter four integer separated with blank:");
    scanf("%d %d %d %d", &num1, &num2, &num3, &num4);
    max=min=num1;
    if(num2>max)
        max=num2;
    else min=num2;
    if(num3>max)
        max=num3;
    else if (num3<min)
        min=num3;
    if(num4>max)
        max=num4;
    else if(num4<min)
        min=num4;
    printf("Largest: %d\nSmallest: %d", max, min);
}
