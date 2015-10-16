#include<stdio.h>
#include<ctype.h>
#define N 20
#define TRUE 1
#define FALSE 0

char stack[N];
int top;

int isEmpty(char stack[]);
int isFull(char stack[]);
void initiate(char stack[]);
void push(char stack[], char ch);
char pop(char stack[]);

int main()
{
    char ch;
    printf("Please enter brackets: ");
    while((ch=getchar())!='\n')
    {
        if(ch=='{' || ch=='(')
            push(stack, ch);
        else if(ch=='}' || ch==')')
            (void)pop(stack);
        else
        {
            printf("Please enter valid bracket.\n");
            return 1;
        }
    }
        if(isEmpty(stack))
            printf("Parentheses/braces are nested properly.\n");
        else
            printf("stack_overflow");
        return 0;
    }

    int isEmpty(char stack[])
    {
        return top==0;
    }

    int isFull(char stack[])
    {
        return top==N;
    }

    void initiate(char stack[])
    {
        top=0;
    }

    void push(char stack[], char ch)
    {
        if(isFull(stack))
        {
            printf("stack is full.\n");
        }
        else
            stack[top++]=ch;
    }

    char pop(char stack[])
    {
        if(isEmpty(stack))
        {
            printf("No element in the stack.\n");
            return stack[top];
        }
        else
            return stack[top--];
    }
