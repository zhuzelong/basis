#include<stdio.h>
#define MAXLENGTH 1000

main()
{
    char inputLine[MAXLENGTH];
    char inputDel[MAXLENGTH];
    getLine(inputLine);
    getLine(inputDel);
    squeeze(inputLine,inputDel);
    printf("%s",inputLine);

}

int getLine(char inputLine[])
{
    int c,i;
    for(i=0;(c=getchar())!=EOF&&c!='\n';++i)
        inputLine[i]=c;
    if(c=='\n')
        inputLine[i++]=c;
    inputLine[i]='\0';
    return i;
}

static char daytab[2][13]={{0,31,28,31,30,31,30,31,31,30,31,30,31},{0,31,29,31,30,31,30,31,31,30,31,30,31}};

int dayYear(int year,int month,int day)
{
    int i,leap;
    leap=year%4==0&&year%100!=0||year%400==0;
    for(i=1;i<month;i++)
        day+=daytab[leap][i];
    return day;
}

void monthDay(int year,int yearday,int *pmonth,int *pday)
{
    int i,leap;
    leap=year%4==0&&year%100!=0||year%400==0;
    for(i=1;yearday>daytab[leap][i]);i++)
        yearday-=daytab[leap][i];
    *pmonth=i;
    *pday=yearday;
}
