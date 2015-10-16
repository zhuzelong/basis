#include<stdio.h>
int main(void)
{
    int matrix[4][4];
    int row=0, col=0;
    for(;row<4;row++)
        for(col=0;col<4;col++)
        {
            printf("Please insert a number:");
            scanf("%d",&matrix[row][col]);
        }
    for(row=0;row<4;row++)
        for(col=0;col<4;col++)
            printf("%2d\t",matrix[row][col]);
    printf("\n");
    return 0;
}
