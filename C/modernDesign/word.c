#include<stdio.h>
#include "word.h"

int read_char(void)
{
    int ch=getchar();
    if(ch=='\n' || ch=='\t')
        return ' '; /* Replace the newline and the tab with blank. */
    return ch;
}

void read_word(char *word, int len)
{
    int ch, pos=0;
    while( (ch=read_char())==' ')
        ; /* Skip the blank */
    while(ch!=' '&& ch!=EOF)
    {
        if(pos<len)
            word[pos++]=ch;
        ch=read_char();
    }
    if(pos==len)
        word[pos++]='*';
    word[pos]='\0';
}
