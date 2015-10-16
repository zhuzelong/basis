#include<stdio.h>
int main()
{
    int digit[5], index, num=0;
    int mode=8;
    int quotation=0;
    printf("Enter a decimal number: ");
    scanf("%d",&num);
    quotation=num;
    for(index=0;index<=4;index++)
    {
        digit[index]=quotation%mode;
        quotation=quotation/mode;
    }
    printf("The octal number is: %d%d%d%d%d", digit[4],digit[3],digit[2],digit[1],digit[0]);
}

