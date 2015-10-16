#include<stdio.h>
int main()
{
    int count=0;
    char ch;
    printf("Enter a sentence: ");
    while((ch=getchar())!='\n')
        switch(ch)
        {
            case 'a': case 'A': case 'e': case 'E': case 'i': case 'I': case 'o': case 'O': case 'u': case 'U': count++; break;
            default: break;
        }
    printf("Your sentence contains %d vowels.", count);
}
