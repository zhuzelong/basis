#include<stdio.h>
#include<ctype.h>
#include<math.h>
#define MAXLENGTH 1000
#define BASE 16

main()
{
    char inputLine[MAXLENGTH];
    char inputDel[MAXLENGTH];
    getLine(inputLine);
    getLine(inputDel);
    squeeze(inputLine,inputDel);
    printf("%s",inputLine);

}

void getLine(char inputLine[])
{
    int c,i;
    for(i=0;(c=getchar())!=EOF&&c!='\n';++i)
        inputLine[i]=c;
    if(c=='\n')
        inputLine[i++]=c;
    inputLine[i]='\0';
    return;
}

void squeeze(char s[],char del[])
{
    int i,j,k;
    for(k=0;del[k]!=EOF;k++)
        for(i=j=0;s[i]!=EOF;i++)
            if(s[i]!=del[k])
                s[j++]=s[i];
    s[j]='\0';
}
