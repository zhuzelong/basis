#include<stdio.h>
int main()
{
    int days=0, start=0;
    printf("Enter number of days in month: ");
    scanf("%d", &days);
    printf("Enter starting day of the week (0=Sun,6=Sat): ");
    scanf("%d", &start);
    int i=0;
    for(i=0;i<start;i++)
        printf("\t");
    for(i=1;i<=days;i++)
    {
        printf("%d\t",i);
        if(i%7==7-start) 
            printf("\n");
    }
}
