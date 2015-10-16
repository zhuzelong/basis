#include<stdio.h>

main()
{
    int c=0;
    int i=0;
    int n=0;
    char line[100];
    line[0]='s';
    while((c=getchar())!='\n')
    {
        line[i++]=c;/*如果是++i，则line[0]仍然是s；如果是i++，则s被输入的字符替换掉。*/
        ++n;
    }
    line[i+1]='\0';
    printf("%s\n%d\t%d",line,i,n);
}
