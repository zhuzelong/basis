#include<stdio.h>

typedef struct
{
    int numerator;
    int denominator;
} FRACTION;

FRACTION simpleFraction(FRACTION f);
FRACTION sumFraction(FRACTION f1, FRACTION f2);
FRACTION minusFraction(FRACTION f1, FRACTION f2);
FRACTION multiFraction(FRACTION f1, FRACTION f2);
FRACTION divideFraction(FRACTION f1, FRACTION f2);
int gcd(int x, int y);

int main(void)
{
    FRACTION f1, f2, f;
    printf("Enter fraction f1: ");
    scanf("%d/%d", &f1.numerator, &f1.denominator);
    printf("Enter fraction f2: ");
    scanf("%d/%d", &f2.numerator, &f2.denominator);

    /* Display the simple form of f1 and f2 */
    f=simpleFraction(f1);
    printf("The simple form of f1 is %d/%d\n", f.numerator, f.denominator);
    f=simpleFraction(f2);
    printf("The simple form of f2 is %d/%d\n", f.numerator, f.denominator);

    /* Display the result of f1 plus f2 */
    f=sumFraction(f1, f2);
    printf("f1 + f2 = %d/%d\n", f.numerator, f.denominator);

    /* Display the result of f1 minus f2 */
    f=minusFraction(f1, f2);
        printf("f1 - f2 = %d/%d\n", f.numerator, f.denominator);

    /* Display the result of f1 multiplies f2 */
    f=multiFraction(f1, f2);
        printf("f1 * f2 = %d/%d\n", f.numerator, f.denominator);

    /* Display the result of f1 divides f2 */
    f=divideFraction(f1, f2);
        printf("f1 / f2 = %d/%d\n", f.numerator, f.denominator);

    return 0;
}

int gcd(int x, int y)
{
    int remainder=0;
    remainder=x%y;
    while(remainder!=0)
    {
        remainder=x%y;
        x=y;
        y=remainder;
    }
    return x;
}

FRACTION simpleFraction(FRACTION f)
{
    FRACTION result;
    int gcdNumber=gcd(f.numerator, f.denominator);
    result.numerator=f.numerator/gcdNumber;
    result.denominator=f.denominator/gcdNumber;
    return result;
}

FRACTION sumFraction(FRACTION f1, FRACTION f2)
{
    FRACTION result;
    result.numerator=f1.numerator*f2.denominator + f2.numerator+f1.denominator;
    result.denominator=f1.denominator*f2.denominator;
    return simpleFraction(result);
}

FRACTION minusFraction(FRACTION f1, FRACTION f2)
{
    FRACTION result;
    result.numerator=f1.numerator*f2.denominator - f2.numerator+f1.denominator;
    result.denominator=f1.denominator*f2.denominator;
    return simpleFraction(result);
}

FRACTION multiFraction(FRACTION f1, FRACTION f2)
{
    /* First, simplify f1 and f2 to avoid overflow */
    f1=simpleFraction(f1);
    f2=simpleFraction(f2);
    FRACTION result;
    result.numerator=f1.numerator*f2.numerator;
    result.denominator=f1.denominator*f2.denominator;
    return simpleFraction(result);
}

FRACTION divideFraction(FRACTION f1, FRACTION f2)
{
    /* First, simplify f1 and f2 to avoid overflow */
    f1=simpleFraction(f1);
    f2=simpleFraction(f2);
    FRACTION result;
    result.numerator=f1.numerator*f2.denominator;
    result.denominator=f1.denominator*f2.numerator;
    return simpleFraction(result);
}
