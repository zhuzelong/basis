#include<stdio.h>
int main()
{
    int number=0;
    int digit[100];
    printf("Enter a number: ");
    scanf("%d", &number);
    int index=0;    
    do
    {
        int temp=number/10;
        digit[index]=number-temp*10;
        number/=10;
        index++;
    } while(number!=0);
    for(int i=0;i<index;i++)
        number=number*10+digit[i];
    printf("the reversed number is %d", number);
}
