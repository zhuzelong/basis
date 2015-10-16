#include<stdio.h>
int main(void)
{
    int day=0, month=0, year=0;
    printf("Please enter a date in mm/dd/yyyy:");
    scanf("%d/%d/%d",&month,&day,&year);
    printf("\nYou entered the date: %d%2d%d\n",year,month,day);
    return 0;
}
