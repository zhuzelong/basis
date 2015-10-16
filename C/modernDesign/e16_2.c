#include<stdio.h>

int main(void)
{
struct
{
double real, imag;
} c1={0.0, 1.0}, c2={1.0, 0.0}, c3;

c1=c2;
c3.real=c1.real+c2.real;
c3.imag=c1.imag+c2.imag;
printf("%g %g\n%g %g\n%g %g\n", c1.real, c1.imag, c2.real, c2.imag, c3.real, c3.imag);
return 0;
}

