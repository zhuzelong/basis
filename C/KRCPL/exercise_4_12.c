#include<stdio.h>
#define MAXLINE 1000
#include<string.h>

main()
{
    long int number=2135343;
    char optLine[MAXLINE];
    itoaRecursive(number,optLine);
    printf("%s",optLine);
}


void itoaRecursive(long int number,char optLine[])
{
    int index=0;
    if(number/10)
        itoaRecursive(number/10,optLine);
    optLine[index++]=number%10+'0';
}
