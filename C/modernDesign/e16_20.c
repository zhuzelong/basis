#include<stdio.h>

int main(void)
{
    enum {NORTH, SOUTH, EAST, WEST} direction;
    int x=0, y=0;
    switch(direction)
    {
        case EAST: x++; break;
        case WEST: x--; break;
        case SOUTH: y++; break;
        case NORTH: y--; break;
    }
    printf("x= %d, y= %d", x, y);
    return 0;
}
