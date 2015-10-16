#include<stdio.h>
#include<ctype.h>
#define N 100 
#define TRUE 1
#define FALSE 0

int stack[N];
int top;

int isEmpty(int stack[]);
int isFull(int stack[]);
void initiate(int stack[]);
void push(int stack[], int ch);
int pop(int stack[]);

int main()
{
    char ch;
    int operand1=0, operand2=0; 
    printf("Please enter the expression: ");
    initiate(stack);
    while((ch=getchar())!='\n')
    {
        if(ch>='0'&&ch<='9' && !isFull(stack))
            push(stack, ch-'0');
        else
        {
            operand1=pop(stack);
            operand2=pop(stack);
            switch(ch)
            {
                case '+': push(stack, operand1+operand2); break;
                case '-': push(stack, operand1-operand2); break;
                case '*': push(stack, operand1*operand2); break;
                case '/': push(stack, operand1/operand2); break;
                default: break; break;
            }
        }
    }
    printf("Value of expression is: %d", pop(stack));
    return 0;
}

int isEmpty(int stack[])
{
    return top==0;
}

int isFull(int stack[])
{
    return top==N;
}

void initiate(int stack[])
{
    top=0;
}

void push(int stack[], int ch)
{
    if(isFull(stack))
    {
        printf("stack is full.\n");
    }
    else
        stack[top++]=ch;
}

int pop(int stack[])
{
    if(isEmpty(stack))
    {
        printf("No element in the stack.\n");
        return stack[top];
    }
    else
        return stack[top--];
}
