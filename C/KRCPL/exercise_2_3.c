#include<stdio.h>
#include<ctype.h>
#include<math.h>
#define MAXLENGTH 1000
#define BASE 16

main()
{
    char inputLine[MAXLENGTH];
    int number;
    /*while((number=htoi(getLine(inputLine)))!=-1)
        printf("%d\n",number);*/
    while(number=getLine(inputLine)!=-1)
        printf("%d\n%s",number,inputLine);

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

int htoi(char inputLine[])
{
    /*if(checkInput(inputLine)==-1)
        return -1;*/
    int exp=0;
    int index=0;
    int integer=0;
    while(inputLine[index]!=EOF)
        index++;
    while(index>1)
    {
        integer+=pow(BASE,exp++);
        index--;
    }
    return integer;
}

int checkInput(char inputLine[])
{
    int index=0;
    if(inputLine[index++]!='0')
        return -1;
    else if(inputLine[index]!='x'&&inputLine[index]!='X')
        return -1;
    index++;
    while(inputLine[index]!=EOF)
        if((inputLine[index]>='0'&&inputLine[index]<='9')||(inputLine[index]>='a'&&inputLine[index]<='f')||(inputLine[index]>='A'&&inputLine[index]<='F'))
            index++;
        else return -1;
    return 1;

}
