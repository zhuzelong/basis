#include<stdio.h>
int main()
{
    int hour=0, min=0;
    char noon[2]="AM";
    printf("Enter a 24-hour time: ");
    scanf("%d:%d", &hour, &min);
    if(hour<0||hour>24||min<0||min>59)
    {
        printf("invalid input");
        return 0;
    }
    if(hour>12)
        noon[0]='P';
    if(hour!=12)
        hour=hour%12;
    printf("Equivalent 12-hour time: %d:%d %s", hour, min, noon);
}
