#include<stdio.h>
#define NELEMS(array) (sizeof(array)/sizeof((array)[0]))

int main(void)
{
    int array[]={1, 2, 4, 8, 16, 32, 64};
    printf("The length is %d.", (int)NELEMS(array));
    return 0;
}
