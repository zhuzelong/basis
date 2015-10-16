#include<stdio.h>
#define LEN 20

int main(void)
{
    char string[LEN];
    /* char stringN2[LEN]; */
    printf("Enter a sentence: ");
    scanf("%20s", string);
    printf("Enter another sentence: ");
    /* gets(stringN2); */
    puts(string);
    /*puts(stringN2); */
    return 0;
}
