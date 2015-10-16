fat_cat="""
I will do a list:
\t * cat food
\t * fish
\t * catnip\n\t * grass
"""

print fat_cat

# A tricky snippet!
#while True:
#    for i in ["/", "-", "|", "\\", "|"]:
#        print "%s\r" % i,

# The tricky snippet v2. The \r will return the cursor to the start of line.
for i in ["/", "-", "|", "\\", "|"]:
    print "%s\t" % i,
    
print '''
i will do a list
\t * cat food
\t * fish
\t * catnip\n\t * grass
'''
