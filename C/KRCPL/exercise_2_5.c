#include<stdio.h>
#include<ctype.h>
#include<math.h>
#define MAXLENGTH 1000

main()
{
    char inputLine[MAXLENGTH];
    char inputDel[MAXLENGTH];
    int loc=0;
    getLine(inputLine);
    getLine(inputDel);
    if((loc=search(inputLine,inputDel))!=-1)
        printf("The first location in string basic is %d.\n",loc);
    else
        printf("string1 does not contain any character as same as that in string2.\n");

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

int search(char s1[],char s2[])
{
    int i,j;
    for(j=0;s2[j]!=EOF;j++)
    {
        for(i=0;s1[i]!=EOF||s1[i]!=s2[j];i++)
            ;
        if(s1[i]!=EOF)
            return i;
        else continue;
    }
    return -1;
}
