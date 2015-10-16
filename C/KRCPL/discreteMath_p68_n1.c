#include<stdio.h>
#include<string.h>

void main()
{
    char p,q;
    char getLogicValue();
    int logicAnd(char p, char q);
    int logicOr(char p ,char q);
    int logicXor(char p ,char q);
    int logicDeduce(char p, char q);
    int logicDoubleDeduce(char p, char q);
    char convert(int value);
    p=getLogicValue();
    q=getLogicValue();
    printf("and is %c.\nor is %c.\nxor is %c.\ndeduce is %c.\ndouble deduce is %c.\n",convert(logicAnd(p,q)),convert(logicOr(p,q)),convert(logicXor(p,q)),convert(logicDeduce(p,q)),convert(logicDoubleDeduce(p,q)));
}

char convert(int value)
{
    switch (value)
    {
        case 1: return 'T';
        case 0: return 'F';
        default:break;
    }
}

char getLogicValue()
{
    char p;
    p=getchar();
    if(p=='T'||p=='t')
        return p;
    else printf("Please insert valid logic value.\n");
}

int logicAnd(char p, char q)
{
    int x,y;
    int value=0;
    if(p=='T'||p=='t')
        x=1;
    else x=0;
    if(q=='T'||q=='t')
        y=1;
    else y=0;
    value=x*y;
    return value;
}

int logicOr(char p ,char q)
{
    int x,y;
    int value=0;
    if(p=='T'||p=='t')
        x=1;
    else x=0;
    if(q=='T'||q=='t')
        y=1;
    else y=0;
    value=x+y;
    if(value==2)
        value=1;
    return value;
}

int logicXor(char p ,char q)
{
   int value=0;
   if(p==q)
    value=0;
   else value=1;
   return value;
}

int logicDeduce(char p, char q)
{
    int x,y;
    int value=0;
    if(p=='T'||p=='t')
        x=0;
    else x=1;
    if(q=='T'||q=='t')
        y=1;
    else y=0;
    value=x+y;
    if(value==2)
        value=1;
    return value;
}

int logicDoubleDeduce(char p, char q)
{
    int x,y;
    int value=0;
    x=logicDeduce(p,q);
    y=logicDeduce(p,q);
    value=x*y;
    return value;
}
