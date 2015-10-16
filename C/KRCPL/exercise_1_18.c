#include<stdio.h>
#define MAXLINE 1000
#include<string.h>

void main()
{
    int len;
    int max; /*maximum length seen so far*/
    char inputLine[MAXLINE];
    inputText(inputLine);
    printf("%s",removeBlank(inputLine));
}

void inputText(char inputLine[])
{
    int c,i;
    for(i=0;(c=getchar())!=EOF&&c!='\n';++i)
        inputLine[i]=c;
    if(c=='\n')
    {
        inputLine[i]=c;
        ++i;
    }
    inputLine[i]='\0';
    return;
}

void removeBlank(char inputLine[])
{
   int basicPointer=0;
   int searchPointer=0;
   while(inputLine[searchPointer]!='\0')
   {
       if(inputLine[searchPointer]!=' '&&inputLine[searchPointer]!='\t')
        inputLine[basicPointer++]=inputLine[searchPointer];
       searchPointer++;
   }
   inputLine[basicPointer]='\0';
   return;
}

