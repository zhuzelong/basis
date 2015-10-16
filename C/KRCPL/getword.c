#include<stdio.h>
#include<string.h>
#include<ctype.h>
#define BUFSIZE 100

char buf[BUFSIZE]; /*buffer for ungerch*/
int bufp=0; /*next free position in buf*/

int getch(void) /*get a possibly pushed-back character*/
{
    return(bufp>0)?buf[--bufp]:getchar();
}

void ungetch(int c) /*push character back on input*/
{
    if(bufp>=BUFSIZE)
        printf("ungetch: too many character.\n");
    else
        buf[bufp++]=c;
}

int getword(char *word,int lim)
{
    int c, getch(void);
    void ungetch(int);
    char *w=word;
    while(isspace(c=getch()))
        ;
    if(c!=EOF)
        *w++=c;
    if(!isalpha(c))
    {
        *w='\0';
        return c;
    }
    for(;--lim>0;w++)
        if(!isalnum(*w=getch()))
    {
        ungetch(*w);
        break;
    }
    *w='\0';
    return word[0];
}
