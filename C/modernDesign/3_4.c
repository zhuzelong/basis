#include<stdio.h>
int main(void)
{
    int first=0, second=0, third=0;
    printf("Please enter phone number in syntax:(xxx)xxx-xxxx");
    scanf("(%d)%d-%d",&first, &second, &third);
    printf("You entered: %d.%d.%d",first, second, third);
    return 0;
}
