#include<stdio.h>

int main(void)
{
struct
{
int x, y;
} x;

struct
{
int x, y;
} y;

printf("%d %d %d %d", x.x, x.y, y.x, y.y);
return 0; 
}
