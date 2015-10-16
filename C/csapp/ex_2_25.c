#include<stdio.h>
float sum_elements(float a[], int len);

int main()
{
    float a[] = {1.0, 2.0, 3.0, 4.0, 5.0};
    float res = sum_elements(a, 0);
    printf("%f", res);
    return 0;
}

float sum_elements(float a[], int len)
{
    int i;
    float result = 0;
    for(i=0; i<=len-1; i++)
        result += a[i];
    return result;
}
