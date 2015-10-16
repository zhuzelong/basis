#include<stdio.h>
int main()
{
    int i=0;
    scanf("%d", &i);
    do
    {
        printf("%d ", i);
        i /=10;
    } while(i>0);
}
