#include<stdio.h>

int main(void)
{
enum {FALSE, TRUE} Bool;
int i;
Bool=2;
Bool++;
i=2*Bool+1;
printf("%d %d", Bool, i);
return 0;
}
