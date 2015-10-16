#include<stdio.h>
int main()
{
    int number=0;
    printf("Enter a number: ");
    scanf("%d", &number);
    for(int i=1;i*i<=number;i++)
    {
        if(i%2==1)
            continue;
        printf("%d\n", i*i);
    }
}
