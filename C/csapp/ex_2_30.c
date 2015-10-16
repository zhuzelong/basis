#include<stdio.h>

int tadd_ok(int x, int y);

int main()
{
    int x = -4012301;
    int y = -4050065;
    printf("%d\n", tadd_ok(x, y));
    return 0;
}

/* Check overflow, if no overflow occurs, return 1 */
int tadd_ok(int x, int y)
{
    int sum = x + y;
    if(x < 0 && y < 0 && sum >= 0)
    {
        printf("Negative overflow!\n");
        return 0;
    }
    else if(x > 0 && y > 0 && sum < 0)
    {
        printf("Positive overflow!\n");
        return 0;
    }
    else
    {
        printf("No overflow.\n");
        return 1;
    }
}
