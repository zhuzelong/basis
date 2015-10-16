#include<stdio.h>
typedef enum
{
    FALSE, TRUE
} BOOL;
typedef struct
{
    int day;
    int month;
    int year;
} DATE;

const int days[12]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int dayOfYear(DATE d);
BOOL isLeap(int year);

int main(void)
{
    DATE inpDate;
    printf("Please enter year, month and day: ");
    scanf("%d\n%d\n%d\n", &inpDate.year, &inpDate.month, &inpDate.day);
    printf("The day is the %dth day of the year.", dayOfYear(inpDate));
}

int dayOfYear(DATE d)
{
    int totalDay=0;
    if(d.month<1 || d.month>12)
    {
        printf("Please insert valid month.");
        return -1;
    }
    if(d.day<1 || d.day>31)
    {
        printf("Please insert valid day.");
        return -1;
    }
    for(int i=0; i<d.month-1; i++)
        totalDay+=days[i];
    totalDay+=d.day;
    return totalDay;
}

BOOL isLeap(int year)
{
    if(year%4==0 && (year%100!=0 || year%400==0))
        return TRUE;
    else
        return FALSE;
}
