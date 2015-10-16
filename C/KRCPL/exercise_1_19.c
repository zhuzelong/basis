#include<stdio.h>
#define MAXLENGTH 1000

void main()
{
    char inputText[MAXLENGTH];
    char tempCharacter;
    int index=0;
    while((tempCharacter=getchar())!='\n')
    {
        inputText[index]=tempCharacter;
        index++;
    }
    reverseString(inputText);
    printf("%s\n",inputText);
}

void reverseString(char inputText[])
{
    int lengthString=0;
    char tempCharacter;
    int index=0;
    while(inputText[index]!=EOF)
        index++;
    lengthString=index;
    for(index=0;index<lengthString/2;index++)
    {
        tempCharacter=inputText[lengthString-1-index];
        inputText[lengthString-1-index]=inputText[index];
        inputText=tempCharacter;
    }
}
