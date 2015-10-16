#include<stdio.h>
#define TRUE 1
#define FALSE 0
int main()
{
    long int number=0l;
    int count[10]={0};
    printf("Enter a number: ");
    scanf("%ld", &number);
    while(number/10!=0)
    {
        int temp=0;
        temp=number%10;
        count[temp]++;
        number/=10;
    }
    printf("Digit:\t");
    for(int i=0;i<10;i++)
        printf("%d\t",i);
    printf("\nOccurrences: \t");
    for(int i=0;i<10;i++)
        printf("%d\t", count[i]);
}
