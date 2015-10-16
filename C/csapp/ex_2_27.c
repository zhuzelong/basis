#include<stdio.h>

int uadd_ok(unsigned x, unsigned y);

int main()
{
    unsigned x = 921401231;
    unsigned y = 231290120;
    printf("%d\n", uadd_ok(x, y));
    return 0;
}

int uadd_ok(unsigned x, unsigned y)
{
    unsigned sum;
    sum = x + y;
    if(sum < x)
    {
        printf("Overflow!\n");
        return 0;
    }
    else return 1;
}
