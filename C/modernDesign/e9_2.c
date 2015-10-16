#include<stdio.h>

int check(int x, int y, int n);

int main(void)
{
    int x, y, n;
    printf("Please enter x, y and n: ");
    scanf("%d %d %d", &x, &y, &n);
    printf("The result is %d.", check(x,y,n));
    return 0;
}

int check(int x, int y, int n)
{
    if(x>=0 && x<=n-1 && y>=0 && y<=n-1)
        return 1;
    else
        return 0;
}
