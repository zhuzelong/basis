#include<stdio.h>
#define LENGTH 40
int main()
{
    int fab[LENGTH]={0,1};
    int i=0;
    for(i=2;i<=LENGTH-1;i++)
        fab[i]=fab[i-1]+fab[i-2];
    for(i=0;i<LENGTH;i++)
        printf("%d ", fab[i]);
}
