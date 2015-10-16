#include<stdio.h>
#include<stdlib.h>

typedef struct
{
    int x, y;
} point;

typedef struct
{
    point upperLeft, lowerRight;
} rectangle;

typedef enum {FALSE, TRUE} Bool;

int squareRec(rectangle r);
point middlePoint(rectangle r);
/* rectangle moveRec(rectangle r); */
Bool position(rectangle r, point p);

int main(void)
{
    rectangle r;
    point testPoint;
    printf("Enter the coordinate of upper left point: ");
    scanf("%d %d", &r.upperLeft.x, &r.upperLeft.y);
    printf("Enter the coordinate of lower right point: ");
    scanf("%d %d", &r.lowerRight.x, &r.lowerRight.y);
    /* Display the square */
    printf("The square of the rectangle is %d\n", squareRec(r));
    /* Display the middle point */
    printf("The coordinate of middle point is (%d, %d)\n", middlePoint(r).x, middlePoint(r).y);
    /* Tell whether a point is in rectangle */
    printf("Enter the coordinate of point to find out if it is in rectangle: ");
    scanf("%d %d", &testPoint.x, &testPoint.y);
    printf("The point is in the rectangle: %d\n", position(r, testPoint));
    return 0;
}

int squareRec(rectangle r)
{
    int height=abs(r.upperLeft.y-r.lowerRight.y);
    int width=abs(r.upperLeft.x-r.lowerRight.x);
    return height*width;
}

point middlePoint(rectangle r)
{
    point middle;
    middle.x=(r.upperLeft.x+r.lowerRight.x)/2;
    middle.y=(r.upperLeft.y+r.lowerRight.y)/2;
    return middle;
}

Bool position(rectangle r, point p)
{
    if(p.x>r.upperLeft.x && p.x<r.lowerRight.x && p.y<r.upperLeft.x && p.y>r.lowerRight.y)
        return TRUE;
    else if(p.x<r.upperLeft.x && p.x>r.lowerRight.x && p.x<r.upperLeft.x && p.x>r.lowerRight.x)
        return TRUE;
    else
        return FALSE;
}
