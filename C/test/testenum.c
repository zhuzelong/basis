#include<stdio.h>

int main(void)
{
    enum {jan=1, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec} month;
    printf("%d %d", jan, apr);
    month=feb;
    printf("%d", month);
    return 0;
}
