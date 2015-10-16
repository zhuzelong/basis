#include<stdio.h>
#include<string.h>
#include "line.h"

#define MAX_LINE_LEN 60

char line[MAX_LINE_LEN+1];
int line_len=0;
int num_words=0;

/* Clear the buffer and reset the counter */
void clear_line(void)
{
    line[0]='\0';
    line_len=0;
    num_words=0;
}

/* Add a word to the line buffer */
void add_word(const char *word)
{
    if(num_words>0)
    {
        line[line_len]=' ';
        line[line_len+1]='\0';
        line_len++;
    }
    strcat(line, word); /* Concatenate the word to the end of line */
    line_len+=strlen(word);
    num_words++;
}

/* Return how many char space is left in a line */
int space_remaining(void)
{
    return MAX_LINE_LEN-line_len;
}

/* Print the buffer line */
void write_line(void)
{
    int extra_spaces, spaces_to_insert, i, j;
    extra_spaces=MAX_LINE_LEN-line_len;
    /* Print the line formatted */
    for(i=0; i<line_len; i++)
    {
        if(line[i] != ' ')
            putchar(line[i]);
        else
        {
            spaces_to_insert=extra_spaces/(num_words-1);
            for(j=1; j<=spaces_to_insert+1; j++)
                putchar(' '); /* Print blanks according to the spaces left */
            extra_spaces-=spaces_to_insert;
            num_words--;
        }
    }
    putchar('\n');
}

/* Print the buffer line */
void flush_line(void)
{
    if(line_len>0)
        puts(line);
}
