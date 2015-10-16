#include<stdio.h>
int main(void)
{
    int itemNumber=0, day=0, month=0, year=0;
    float price=0.0f;
    printf("Please enter item number:");
    scanf("%d",&itemNumber);
    printf("Please enter unit price:");
    scanf("%f",&price);
    printf("Please enter purchase date:");
    scanf("%d/%d/%d",&month,&day,&year);
    printf("Item\tUnit\tPurchase\n\tPrice\tDate\n%-4d\t$%4.2f\t%-2d/%d/%d",itemNumber, price, month, day, year);
    return 0;
}
