#include<stdio.h>
int main()
{
float operand1=0.0f, operand2=0.0f, operand3=0.0f;
char operator1, operator2;
float sum=0.0f;
printf("Enter an expression: ");
scanf("%f%c%f%c%f", &operand1, &operator1, &operand2, &operator2, &operand3);
switch(operator1)
{
case '+': sum=operand1+operand2; break;
case '-': sum=operand1-operand2; break;
case '*': sum=operand1*operand2; break;
case '/': sum=operand1/operand2; break;
default: printf("Please enter a valid operator."); return 0;
}
switch(operator2)
{
case '+': sum+=operand3; break;
case '-': sum-=operand3; break;
case '*': sum*=operand3; break;
case '/': sum/=operand3; break;
default: printf("Please enter a valid operator."); return 0;
}
printf("Value of expression: %g", sum);
}

