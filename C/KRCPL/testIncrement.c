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
        line[i++]=c;/*�����++i����line[0]��Ȼ��s�������i++����s��������ַ��滻����*/
        ++n;
    }
    line[i+1]='\0';
    printf("%s\n%d\t%d",line,i,n);
}
